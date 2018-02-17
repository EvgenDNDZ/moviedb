package com.railsreactor.moviedbapp.presentation.base;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.railsreactor.moviedbapp.BR;

import javax.inject.Inject;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class MvvmActivity<B extends ViewDataBinding, V extends ViewModel> extends CompositeActivity {

    @Inject Class<V> viewModelClass;
    @Inject ViewModelProvider.Factory viewModelFactory;

    protected B binding;
    protected V viewModel;

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected final View setAndBindContentView(@NonNull Activity activity, @Nullable Bundle savedInstanceState, @LayoutRes int layoutResID) {
        setContentView(layoutResID);
        binding = DataBindingUtil.setContentView(this ,layoutResID);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass);
        binding.setVariable(BR.vm, viewModel);
        return binding.getRoot();
    }
}
