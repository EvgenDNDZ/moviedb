package com.railsreactor.moviedbapp.presentation.main;

import com.railsreactor.moviedbapp.data.exeptions.ErrorMessageFactory;
import com.railsreactor.moviedbapp.domain.interactor.GetMoviesListUseCase;
import com.railsreactor.moviedbapp.presentation.base.BaseLoadingActivityViewModel;

import javax.inject.Inject;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class MainActivityViewModel extends BaseLoadingActivityViewModel {

    @Inject GetMoviesListUseCase getMoviesListUseCase;

    @Inject
    public MainActivityViewModel(ErrorMessageFactory errorMessageFactory) {
        super(errorMessageFactory);
    }

    @Override
    public void reloadData() {

    }
}
