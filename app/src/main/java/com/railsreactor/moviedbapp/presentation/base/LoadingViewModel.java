package com.railsreactor.moviedbapp.presentation.base;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.view.View;

import io.reactivex.functions.Action;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public interface LoadingViewModel {

    ObservableField<String> getErrorMessage();

    ObservableField<Action> getRetryAction();

    ObservableBoolean isLoading();

    void startLoading(Action action, boolean retryable);
    void startLoading(Action action, boolean isShowLoading, boolean retryable, View button);

    void onCompleteLoading();

    void onFailLoading(Throwable throwable);

    void reloadData();

}
