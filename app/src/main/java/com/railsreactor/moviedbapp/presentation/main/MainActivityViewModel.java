package com.railsreactor.moviedbapp.presentation.main;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ObservableBoolean;
import android.os.Bundle;

import com.railsreactor.moviedbapp.data.exceptions.ErrorMessageFactory;
import com.railsreactor.moviedbapp.domain.interactor.GetMoviesListUseCase;
import com.railsreactor.moviedbapp.domain.models.Movie;
import com.railsreactor.moviedbapp.presentation.base.AppNavigator;
import com.railsreactor.moviedbapp.presentation.base.BaseLoadingActivityViewModel;
import com.railsreactor.moviedbapp.presentation.main.adapter.MoviesListAdapter;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class MainActivityViewModel extends BaseLoadingActivityViewModel implements MoviesListAdapter.MovieItemClickCallback {

    @Inject MoviesListAdapter moviesListAdapter;
    @Inject GetMoviesListUseCase getMoviesListUseCase;

    AppNavigator appNavigator;

    private int currentPage = 0;
    int totalPages = 0;
    boolean isLastPage = false;

    private final ObservableBoolean isUpdating = new ObservableBoolean();

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
        currentPage = 0;
        startLoading(this::updateMoviesList, true);
    }

    public void updateMoviesList() {
        updateMoviesListAsync(++currentPage);
    }

    private void updateMoviesListAsync(int pageIndex) {
        this.getMoviesListUseCase.execute(pageIndex,
                moviesListResponses -> {
                    getIsUpdating().set(false);
                    getMoviesListAdapter().addItems(moviesListResponses.getResults());
                    this.totalPages = moviesListResponses.getTotalPages();
                    this.isLastPage = this.currentPage == moviesListResponses.getTotalPages();
                    onCompleteLoading();
                },
                this::onFailLoading);
    }

    public ObservableBoolean getIsUpdating() {
        return isUpdating;
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

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        Timber.d("Observer", ": onResume");
        if(currentPage<1){
            reloadData();
        }
    }

    @Override
    public void onMovieClick(Movie movie) {
        Bundle args = new Bundle();
        args.putInt(Movie.class.getSimpleName(), movie.getId());
        appNavigator.navigateToMovieDetails(args);
    }
}
