package com.railsreactor.moviedbapp.presentation.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.railsreactor.moviedbapp.R;
import com.railsreactor.moviedbapp.databinding.ActivityMainBinding;
import com.railsreactor.moviedbapp.presentation.base.AppNavigator;
import com.railsreactor.moviedbapp.presentation.base.MvvmLoadingActivity;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class MainActivity extends MvvmLoadingActivity<ActivityMainBinding, MainActivityViewModel> implements HasSupportFragmentInjector {

    @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;
    @Inject AppNavigator appNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAndBindContentView(this, savedInstanceState, R.layout.activity_main);
        viewModel.setAppNavigator(this.appNavigator);
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
