package com.railsreactor.moviedbapp;

import android.app.Activity;
import android.app.Application;
import android.app.Service;

import com.railsreactor.moviedbapp.di.AppInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;
import timber.log.Timber;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class MovieDBApp extends Application implements HasActivityInjector{

    private final int MIN_CACHE_SIZE_IN_MEGABYTES = 75;
    private final int MAX_CACHE_SIZE_IN_MEGABYTES = 500;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Service> dispatchingServiceAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        AppInjector.init(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
