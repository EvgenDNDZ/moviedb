package com.railsreactor.moviedbapp.domain.interactor.base;

import android.support.annotation.NonNull;

import com.railsreactor.moviedbapp.domain.executor.PostExecutionThread;
import com.railsreactor.moviedbapp.domain.executor.UseCaseExecutor;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * This class represents an execution unit for different use cases (this means any use case in
 * the application should implement this contract).
 * <p>
 * By convention each {@link UseCase} implementation will return the result using a
 * {@link DisposableObserver} that will execute its job in a background thread and will post
 * the result in the UI thread.
 *
 * @author Evgeny Kubay on 2/17/18.
 */

public abstract class UseCase<T, P> extends BaseUseCase {

    public UseCase(UseCaseExecutor useCaseExecutor, PostExecutionThread postExecutionThread) {
        super(useCaseExecutor, postExecutionThread);
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
     */
    protected abstract Observable<T> buildObservable(P params);

    /**
     * Executes the current use case.
     *
     * @param observer {@link DisposableObserver} which will be listening to the observable build
     *                 by {@link #buildObservable(P)} ()} method.
     * @param params   Parameters (Optional) used to build/execute this use case.
     */

    public void execute(@NonNull DisposableObserver<T> observer, P params) {
        final Observable<T> observable = configureObservable(params);
        this.disposables.add(observable.subscribeWith(observer));
    }

    public void execute(P params, @NonNull Consumer<? super T> onNext) {
        final Observable<T> observable = configureObservable(params);
        this.disposables.add(observable.subscribe(onNext));
    }

    public void execute(P params, @NonNull Consumer<? super T> onNext,
                        @NonNull Consumer<? super Throwable> onError) {
        final Observable<T> observable = configureObservable(params);
        this.disposables.add(observable.subscribe(onNext, onError));
    }

    public void execute(P params, @NonNull Consumer<? super T> onNext,
                        @NonNull Consumer<? super Throwable> onError, @NonNull Action onComplete) {
        final Observable<T> observable = configureObservable(params);
        this.disposables.add(observable.subscribe(onNext, onError, onComplete));
    }

    public void execute(P params, @NonNull Consumer<? super T> onNext,
                        @NonNull Consumer<? super Throwable> onError, @NonNull Action onComplete,
                        @NonNull Consumer<? super Disposable> onSubscribe) {
        final Observable<T> observable = configureObservable(params);
        this.disposables.add(observable.subscribe(onNext, onError, onComplete, onSubscribe));
    }

    private Observable<T> configureObservable(P params) {
        return buildObservable(params)
                .subscribeOn(Schedulers.from(useCaseExecutor))
                .observeOn(postExecutionThread.getScheduler());
    }

}
