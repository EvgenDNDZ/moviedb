package com.railsreactor.moviedbapp.presentation.details;

import android.os.Bundle;

import com.railsreactor.moviedbapp.R;
import com.railsreactor.moviedbapp.databinding.ActivityMoviesDetailsBinding;
import com.railsreactor.moviedbapp.domain.models.Movie;
import com.railsreactor.moviedbapp.presentation.base.MvvmLoadingActivity;
import com.railsreactor.moviedbapp.presentation.base.Navigator;

/**
 * @author Evgeny Kubay on 2/18/18.
 */

public class MoviesDetailsActivity extends MvvmLoadingActivity<ActivityMoviesDetailsBinding, MoviesDetailsActivityViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAndBindContentView(this, savedInstanceState, R.layout.activity_movies_details);
        initToolbar();
        if(savedInstanceState == null && getIntent().hasExtra(Navigator.EXTRA_ARG)){
            viewModel.updateMoviesDetails(getIntent().getBundleExtra(Navigator.EXTRA_ARG).getInt(Movie.class.getSimpleName()));
        }
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.title_movies_details);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
