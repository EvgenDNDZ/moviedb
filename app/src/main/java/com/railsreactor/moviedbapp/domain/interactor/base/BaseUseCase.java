package com.railsreactor.moviedbapp.domain.interactor.base;

import com.railsreactor.moviedbapp.domain.executor.PostExecutionThread;
import com.railsreactor.moviedbapp.domain.executor.UseCaseExecutor;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * This class represents an execution unit for different use cases (this means any use case in
 * the application should implement this contract).
 * <p>
 * By convention each {@link BaseUseCase} implementation will return the result using a
 * {@link DisposableObserver} that will execute its job in a background thread and will post
 * the result in the UI thread.
 *
 *
 * @author Evgeny Kubay on 2/17/18.
 */

public abstract class BaseUseCase {

    final UseCaseExecutor useCaseExecutor;
    final PostExecutionThread postExecutionThread;

    protected CompositeDisposable disposables;

    BaseUseCase(UseCaseExecutor useCaseExecutor, PostExecutionThread postExecutionThread) {
        this.useCaseExecutor = useCaseExecutor;
        this.postExecutionThread = postExecutionThread;
        this.disposables = new CompositeDisposable();
    }

    /**
     * Unsubscribes fromInt current {@link Disposable}.
     */
    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.clear();
        }
    }
}
