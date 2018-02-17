package com.railsreactor.moviedbapp.presentation.base;

import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.railsreactor.moviedbapp.R;

import io.reactivex.functions.Action;
import timber.log.Timber;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class SnackbarErrorViewer {

    private final View container;

    private Action retryAction;
    private String errorMessage;

    private Snackbar snackbar;

    public SnackbarErrorViewer(View container) {
        this.container = container;
    }

    public void show() {
        if (errorMessage != null && !errorMessage.trim().isEmpty()) {
            this.snackbar = Snackbar.make(container, errorMessage, Snackbar.LENGTH_LONG);
            if (retryAction != null) {
                snackbar.setDuration(Snackbar.LENGTH_INDEFINITE);
                snackbar.setActionTextColor(ContextCompat.getColor(container.getContext(), R.color.colorRed));
                snackbar.setAction(R.string.retry, v -> {
                    try {
                        retryAction.run();
                    } catch (Exception e) {
                        Timber.e(e);
                    }
                });
            }
            snackbar.show();
        } else {
            if (snackbar != null) {
                snackbar.dismiss();
            }
        }
    }

    public void dismiss() {
        this.retryAction = null;
        this.errorMessage = null;
        this.snackbar.dismiss();
    }

    public void clear() {
        this.retryAction = null;
        this.errorMessage = null;
    }


    public Action getRetryAction() {
        return retryAction;
    }

    public void setRetryAction(Action retryAction) {
        this.retryAction = retryAction;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        show();
    }

    public boolean isShowing(){
        return snackbar != null && snackbar.isShown();
    }
}
