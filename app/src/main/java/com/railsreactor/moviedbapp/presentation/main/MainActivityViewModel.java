package com.railsreactor.moviedbapp.presentation.main;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;

import com.railsreactor.moviedbapp.data.exeptions.ErrorMessageFactory;
import com.railsreactor.moviedbapp.domain.interactor.GetMoviesListUseCase;
import com.railsreactor.moviedbapp.presentation.base.BaseLoadingActivityViewModel;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class MainActivityViewModel extends BaseLoadingActivityViewModel {

    @Inject GetMoviesListUseCase getMoviesListUseCase;
    private int currentPage = 0;

    @Inject
    public MainActivityViewModel(ErrorMessageFactory errorMessageFactory) {
        super(errorMessageFactory);
    }

    @Override
    public void reloadData() {
        this.getMoviesListUseCase.execute(++currentPage,
                moviesListResponses -> {

                },
                this::onFailLoading);

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        Timber.d("Observer", ": onDestroy");
        this.getMoviesListUseCase.dispose();
    }
}
