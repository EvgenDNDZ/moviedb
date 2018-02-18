package com.railsreactor.moviedbapp.presentation.main.adapter;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.railsreactor.moviedbapp.R;
import com.railsreactor.moviedbapp.databinding.MoviesListItemBinding;
import com.railsreactor.moviedbapp.domain.models.Movie;
import com.railsreactor.moviedbapp.presentation.base.adapter.DataBoundListAdapter;

import java.util.Objects;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class MovieListAdapter extends DataBoundListAdapter<Movie, MoviesListItemBinding> {

    private MovieItemClickCallback callback;

    public void init(MovieItemClickCallback callback){
        this.callback = callback;
    }

    @Override
    protected MoviesListItemBinding createBinding(ViewGroup parent) {
        MoviesListItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.movies_list_item, parent, false);
        binding.getRoot().setOnClickListener(v -> {
            if (callback != null) {
                callback.onMovieClick(binding.getModel());
            }
        });
        return binding;
    }

    @Override
    protected void bind(MoviesListItemBinding binding, Movie item) {
        binding.setModel(item);
    }

    @Override
    protected boolean areItemsTheSame(Movie oldItem, Movie newItem) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return Objects.equals(oldItem.getId(), newItem.getId());
        }else{
            return objectEquals(oldItem.getId(), newItem.getId());
        }
    }

    @Override
    protected boolean areContentsTheSame(Movie oldItem, Movie newItem) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return Objects.equals(oldItem.getTitle(), newItem.getTitle());
        }else{
            return objectEquals(oldItem.getTitle(), newItem.getTitle());
        }
    }

    public interface MovieItemClickCallback{
        void onMovieClick(Movie movie);
    }
}
