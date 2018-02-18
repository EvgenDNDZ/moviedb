package com.railsreactor.moviedbapp.presentation.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.railsreactor.moviedbapp.R;
import com.railsreactor.moviedbapp.databinding.ActivityMainBinding;
import com.railsreactor.moviedbapp.presentation.base.AppNavigator;
import com.railsreactor.moviedbapp.presentation.base.MvvmLoadingActivity;
import com.railsreactor.moviedbapp.presentation.base.adapter.PaginationScrollListener;

import javax.inject.Inject;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public class MainActivity extends MvvmLoadingActivity<ActivityMainBinding, MainActivityViewModel>{

    @Inject AppNavigator appNavigator;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAndBindContentView(this, savedInstanceState, R.layout.activity_main);
        viewModel.setAppNavigator(this.appNavigator);
        initToolbar();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        binding.rvMoviesList.setLayoutManager(layoutManager);
        binding.rvMoviesList.addOnScrollListener(new PaginationScrollListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                viewModel.getIsUpdating().set(true);
                viewModel.updateMoviesList();
            }

            @Override
            public int getTotalPageCount() {
                return viewModel.totalPages;
            }

            @Override
            public boolean isLastPage() {
                return viewModel.isLastPage;
            }

            @Override
            public boolean isLoading() {
                return viewModel.getIsUpdating().get();
            }
        });
    }

    private void initToolbar() {
        setTitle(R.string.title_upcoming_movies);
    }

}
