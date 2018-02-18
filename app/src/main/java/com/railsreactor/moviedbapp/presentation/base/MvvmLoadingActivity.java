package com.railsreactor.moviedbapp.presentation.base;

import android.databinding.Observable;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import io.reactivex.functions.Action;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class MvvmLoadingActivity<B extends ViewDataBinding, V extends BaseLoadingActivityViewModel> extends MvvmActivity<B, V> {

    protected SnackbarErrorViewer snackbarErrorViewer;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setupErrorView();
        if (savedInstanceState == null) {
            this.viewModel.reloadData();
        }
    }

    private void setupErrorView() {
        this.snackbarErrorViewer = new SnackbarErrorViewer(this.binding.getRoot());
        this.viewModel.getErrorMessage().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                snackbarErrorViewer.setErrorMessage((String) viewModel.getErrorMessage().get());
            }
        });
        this.viewModel.getRetryAction().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                snackbarErrorViewer.setRetryAction((Action) viewModel.getRetryAction().get());
            }
        });
    }
}
