package com.railsreactor.moviedbapp.di;

import com.railsreactor.moviedbapp.presentation.details.MoviesDetailsActivity;
import com.railsreactor.moviedbapp.presentation.details.MoviesDetailsActivityModule;
import com.railsreactor.moviedbapp.presentation.main.MainActivity;
import com.railsreactor.moviedbapp.presentation.main.MainActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = {MainActivityModule.class, FragmentBuildersModule.class})
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = {MoviesDetailsActivityModule.class, FragmentBuildersModule.class})
    abstract MoviesDetailsActivity contributeMoviesDetailsActivity();

}
