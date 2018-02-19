package com.railsreactor.moviedbapp.presentation.base;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.view.View;

import com.railsreactor.moviedbapp.data.exceptions.ErrorMessageFactory;

import java.lang.ref.WeakReference;

import io.reactivex.functions.Action;
import timber.log.Timber;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public abstract class BaseLoadingActivityViewModel extends BaseActivityViewModel implements LoadingViewModel {

    private final ErrorMessageFactory errorMessageFactory;

    protected ObservableField<String> errorMessage = new ObservableField<>();
    protected ObservableField<Action> retryAction = new ObservableField<>();
    protected ObservableBoolean loading = new ObservableBoolean();
    protected WeakReference<View> button;

    public BaseLoadingActivityViewModel(ErrorMessageFactory errorMessageFactory) {
        this.errorMessageFactory = errorMessageFactory;
    }

    @Override
    public ObservableField<String> getErrorMessage() {
        return this.errorMessage;
    }

    @Override
    public ObservableField<Action> getRetryAction() {
        return this.retryAction;
    }

    @Override
    public ObservableBoolean isLoading() {
        return this.loading;
    }

    @Override
    public void startLoading(Action action, boolean isShowLoading, boolean retryable, View button) {
        this.button = new WeakReference<>(button);
        this.button.get().setClickable(false);
        this.loading.set(isShowLoading);
        this.errorMessage.set(null);
        if (retryable) {
            this.retryAction.set(() -> startLoading(action, true));
        }
        try {
            action.run();
        } catch (Exception e) {
            onFailLoading(e);
        }
    }

    @Override
    public void startLoading(Action action, boolean retryable) {
        this.loading.set(true);
        this.errorMessage.set(null);
        if (retryable) {
            this.retryAction.set(() -> startLoading(action, true));
        }
        try {
            action.run();
        } catch (Exception e) {
            onFailLoading(e);
        }
    }

    @Override
    public void onCompleteLoading() {
        this.loading.set(false);
        this.retryAction.set(null);
        this.errorMessage.set(null);
        if (this.button != null && this.button.get() != null) {
            this.button.get().setClickable(true);
            this.button = null;
        }
    }

    @Override
    public void onFailLoading(Throwable throwable) {
        this.loading.set(false);
        handleError(throwable);
        if (this.button != null && this.button.get() != null) {
            this.button.get().setClickable(true);
            this.button.clear();
            this.button = null;
        }
    }

    private void handleError(Throwable throwable) {
        Timber.e(throwable.toString());
        this.errorMessage.set(this.errorMessageFactory.create(throwable));
    }

}
