package com.railsreactor.moviedbapp.presentation.base;

import android.os.Bundle;

import com.railsreactor.moviedbapp.presentation.main.MainActivity;

import javax.inject.Inject;

/**
 * @author Evgeny Kubay on 2/17/18.
 */
public class AppNavigator {

    private final ActivityNavigator activityNavigator;

    @Inject
    public AppNavigator(ActivityNavigator activityNavigator) {
        this.activityNavigator = activityNavigator;
    }

    public void navToPreviousActivity(){
        activityNavigator.getActivity().onBackPressed();
    }

    public void navigateToMain() {
        this.activityNavigator.startActivity(MainActivity.class);
    }

    public void navigateToMovieDetails(Bundle args) {
    }
}
