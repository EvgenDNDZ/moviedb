package com.railsreactor.moviedbapp.presentation.details;

import com.railsreactor.moviedbapp.data.exeptions.ErrorMessageFactory;
import com.railsreactor.moviedbapp.presentation.base.BaseLoadingActivityViewModel;

import javax.inject.Inject;

/**
 * @author Evgeny Kubay on 2/18/18.
 */

public class MoviesDetailsActivityViewModel extends BaseLoadingActivityViewModel {

    @Inject
    public MoviesDetailsActivityViewModel(ErrorMessageFactory errorMessageFactory) {
        super(errorMessageFactory);
    }

    @Override
    public void reloadData() {

    }

    public void updateMoviesDetails(String id){

    }

    private void loadMoviesDetailsAsync(String id){}
}
