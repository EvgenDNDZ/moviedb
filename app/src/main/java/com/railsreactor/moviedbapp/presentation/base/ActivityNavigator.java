package com.railsreactor.moviedbapp.presentation.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.railsreactor.moviedbapp.utils.PlainConsumer;

import javax.inject.Inject;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class ActivityNavigator implements Navigator {

    public static final String FRAGMENT_TAG = "content";

    private final FragmentActivity activity;
    private final FragmentManager fragmentManager;

    @Inject
    public ActivityNavigator(FragmentActivity activity, FragmentManager fragmentManager) {
        this.activity = activity;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void finishActivity() {
        activity.finish();
    }

    public FragmentActivity getActivity(){
        return activity;
    }

    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    @Override
    public final void startActivity(@NonNull Intent intent) {
        activity.startActivity(intent);
    }

    @Override
    public void startActivity(@NonNull Class<? extends Activity> activityClass) {

    }

    @Override
    public void startActivity(@NonNull Class<? extends Activity> activityClass, Bundle args) {
        startActivityInternal(activityClass, intent -> intent.putExtra(EXTRA_ARG, args), null);
    }

    private void startActivityInternal(Class<? extends Activity> activityClass, PlainConsumer<Intent> setArgsAction, Integer requestCode) {
        Intent intent = new Intent(activity, activityClass);
        if(setArgsAction != null) { setArgsAction.accept(intent); }

        if(requestCode != null) {
            activity.startActivityForResult(intent, requestCode);
        } else {
            activity.startActivity(intent);
        }
    }

}
