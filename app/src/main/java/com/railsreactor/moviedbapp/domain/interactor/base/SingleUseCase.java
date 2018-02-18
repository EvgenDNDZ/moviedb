package com.railsreactor.moviedbapp.domain.interactor.base;

import android.support.annotation.NonNull;

import com.railsreactor.moviedbapp.domain.executor.PostExecutionThread;
import com.railsreactor.moviedbapp.domain.executor.UseCaseExecutor;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * This class represents an execution unit for different use cases (this means any use case in
 * the application should implement this contract).
 * <p>
 * By convention each {@link SingleUseCase} implementation will return the result using a
 * {@link DisposableObserver} that will execute its job in a background thread and will post
 * the result in the UI thread.
 *
 * @author Evgeny Kubay on 2/17/18.
 */

public abstract class SingleUseCase<T, P> extends BaseUseCase {

    public SingleUseCase(UseCaseExecutor useCaseExecutor, PostExecutionThread postExecutionThread) {
        super(useCaseExecutor, postExecutionThread);
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current
     * {@link SingleUseCase}.
     */
    protected abstract Single<T> buildSingle(P params);

    /**
     * Executes the current use case.
     *
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    public void execute(P params, @NonNull Consumer<? super T> onSuccess) {
        execute(params, onSuccess, Functions.emptyConsumer());
    }

    public void execute(P params, @NonNull Consumer<? super T> onSuccess,
                        @NonNull Consumer<? super Throwable> onError) {
        final Single<T> observable = configureObservable(params);
        this.disposables.add(observable.subscribe(onSuccess, onError));
    }

    private Single<T> configureObservable(P params) {
        return buildSingle(params)
                .subscribeOn(Schedulers.from(useCaseExecutor))
                .observeOn(postExecutionThread.getScheduler());
    }

    private Single<T> configureObservable(P params, boolean executeOnMainThread) {
        return buildSingle(params)
                .subscribeOn(executeOnMainThread ? postExecutionThread.getScheduler() :
                        Schedulers.from(useCaseExecutor))
                .observeOn(postExecutionThread.getScheduler());
    }

}
