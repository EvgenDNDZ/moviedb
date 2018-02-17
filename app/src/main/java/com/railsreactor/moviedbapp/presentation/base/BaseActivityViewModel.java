package com.railsreactor.moviedbapp.presentation.base;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.os.Parcelable;

import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public abstract class BaseActivityViewModel extends ViewModel {

    protected final CompositeDisposable nitificationCompositeDisposable = new CompositeDisposable();
    protected final CompositeDisposable eventCompositeDisposable = new CompositeDisposable();

    public BaseActivityViewModel() {
    }

    private Bundle createBundle(String key, Parcelable value){
        Bundle args = new Bundle();
        args.putParcelable(key, value);
        return args;
    }
}
