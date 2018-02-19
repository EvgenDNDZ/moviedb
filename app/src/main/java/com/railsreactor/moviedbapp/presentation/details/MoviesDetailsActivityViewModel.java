package com.railsreactor.moviedbapp.presentation.details;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.ObservableField;

import com.railsreactor.moviedbapp.data.exeptions.ErrorMessageFactory;
import com.railsreactor.moviedbapp.domain.interactor.GetMoviesDetailsUseCase;
import com.railsreactor.moviedbapp.domain.models.MovieDetails;
import com.railsreactor.moviedbapp.presentation.base.BaseLoadingActivityViewModel;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * @author Evgeny Kubay on 2/18/18.
 */

public class MoviesDetailsActivityViewModel extends BaseLoadingActivityViewModel {

    @Inject GetMoviesDetailsUseCase getMoviesDetailsUseCase;

    private final ObservableField<MovieDetails> movieDetails = new ObservableField<>();

    @Inject
    public MoviesDetailsActivityViewModel(ErrorMessageFactory errorMessageFactory) {
        super(errorMessageFactory);
    }

    public ObservableField<MovieDetails> getMovieDetails() {
        return movieDetails;
    }

    @Override
    public void reloadData() {

    }

    public void updateMoviesDetails(int id){
        startLoading(() -> loadMoviesDetailsAsync(id), true);
    }

    private void loadMoviesDetailsAsync(int id){
        this.getMoviesDetailsUseCase.execute(id,
                mDetails -> {
                    getMovieDetails().set(mDetails);
                    onCompleteLoading();
                },
                this::onFailLoading);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        Timber.d("Observer", ": onDestroy");
        this.getMoviesDetailsUseCase.dispose();
    }
}
