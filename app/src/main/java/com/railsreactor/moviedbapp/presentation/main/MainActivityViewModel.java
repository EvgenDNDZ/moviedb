package com.railsreactor.moviedbapp.presentation.main;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.os.Bundle;

import com.railsreactor.moviedbapp.data.exeptions.ErrorMessageFactory;
import com.railsreactor.moviedbapp.domain.interactor.GetMoviesListUseCase;
import com.railsreactor.moviedbapp.domain.models.Movie;
import com.railsreactor.moviedbapp.presentation.base.AppNavigator;
import com.railsreactor.moviedbapp.presentation.base.BaseLoadingActivityViewModel;
import com.railsreactor.moviedbapp.presentation.base.Navigator;
import com.railsreactor.moviedbapp.presentation.main.adapter.MoviesListAdapter;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class MainActivityViewModel extends BaseLoadingActivityViewModel implements MoviesListAdapter.MovieItemClickCallback {

    @Inject MoviesListAdapter moviesListAdapter;
    @Inject GetMoviesListUseCase getMoviesListUseCase;
    private int currentPage = 0;
    AppNavigator appNavigator;

    @Inject
    public MainActivityViewModel(ErrorMessageFactory errorMessageFactory) {
        super(errorMessageFactory);
    }

    public void setAppNavigator(AppNavigator appNavigator) {
        this.appNavigator = appNavigator;
    }

    public MoviesListAdapter getMoviesListAdapter() {
        return moviesListAdapter;
    }

    @Override
    public void reloadData() {
        this.getMoviesListUseCase.execute(++currentPage,
                moviesListResponses -> {
                    getMoviesListAdapter().replace(moviesListResponses.getResults());
                },
                this::onFailLoading);

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        Timber.d("Observer", " onCreate");
        getMoviesListAdapter().init(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        Timber.d("Observer", ": onDestroy");
        this.getMoviesListUseCase.dispose();
    }

    @Override
    public void onMovieClick(Movie movie) {
        Bundle args = new Bundle();
        args.putParcelable(Navigator.EXTRA_ARG, movie);
        appNavigator.navigateToMovieDetails(args);
    }
}
