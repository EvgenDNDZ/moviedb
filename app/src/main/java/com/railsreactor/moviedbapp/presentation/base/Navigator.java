package com.railsreactor.moviedbapp.presentation.base;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public interface Navigator {

    String EXTRA_ARG = "_args";

    void finishActivity();
    void startActivity(@NonNull Intent intent);
    void startActivity(@NonNull Class<? extends Activity> activityClass);
}
