package com.railsreactor.moviedbapp.presentation.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ViewModel;

/**
 * @Author evgen on 16.11.2017.
 */

public class BaseViewModel extends ViewModel implements LifecycleObserver {

    public void setLifecycleObserver(Lifecycle lifecycle){
        lifecycle.addObserver(this);
    }
}
