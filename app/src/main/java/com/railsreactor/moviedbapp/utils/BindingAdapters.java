package com.railsreactor.moviedbapp.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.railsreactor.moviedbapp.R;
import com.railsreactor.moviedbapp.presentation.base.adapter.DataBoundListAdapter;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class BindingAdapters {

    @BindingAdapter("viewVisibility")
    public static void setVisibility(View view, boolean isVisible) {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("imageUrl")
    public static void loadImage(AppCompatImageView imageView, String img) {
        Glide.with(imageView.getContext())
                .load(img)
//                .fitCenter()
                .placeholder(R.drawable.progress_animation_with_padding)
                .error(R.drawable.placeholder_image_error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }

    @BindingAdapter(value = {"bindAdapter", "bindOrientation"})
    public static void bindAdapter(RecyclerView view, DataBoundListAdapter adapter, int orientation) {
        view.setLayoutManager(new LinearLayoutManager(view.getContext(), orientation, false));
        view.setAdapter(adapter);
    }

}
