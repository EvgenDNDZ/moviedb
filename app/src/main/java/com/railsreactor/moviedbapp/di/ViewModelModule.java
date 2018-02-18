package com.railsreactor.moviedbapp.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.railsreactor.moviedbapp.presentation.base.MovieDBAppViewModelFactory;
import com.railsreactor.moviedbapp.presentation.details.MoviesDetailsActivityViewModel;
import com.railsreactor.moviedbapp.presentation.main.MainActivityViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel.class)
    abstract ViewModel bindMainActivityViewModel(MainActivityViewModel mainActivityViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MoviesDetailsActivityViewModel.class)
    abstract ViewModel bindMoviesDetailsActivityViewModel(MoviesDetailsActivityViewModel moviesDetailsActivityViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(MovieDBAppViewModelFactory appViewModelFactory);

}
