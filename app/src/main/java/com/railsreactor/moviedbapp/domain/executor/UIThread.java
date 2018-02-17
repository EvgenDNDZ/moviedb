package com.railsreactor.moviedbapp.domain.executor;


import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * MainThread (UI Thread) implementation based on a {@link Scheduler} which will execute
 * actions on the Android UI thread
 *
 * @author Evgeny Kubay on 2/17/18.
 */
@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    public UIThread() {
        // empty
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
