package com.railsreactor.moviedbapp.presentation.details;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;

/**
 * @author Evgeny Kubay on 2/18/18.
 */

@Module
public class MoviesDetailsActivityModule {

    @Provides
    FragmentActivity provideActivity(MoviesDetailsActivity activity) {
        return activity;
    }

    @Provides
    FragmentManager provideFragmentManager(MoviesDetailsActivity activity) {
        return activity.getSupportFragmentManager();
    }
}
