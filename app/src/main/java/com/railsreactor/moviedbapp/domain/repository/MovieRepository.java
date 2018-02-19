package com.railsreactor.moviedbapp.domain.repository;

import com.railsreactor.moviedbapp.data.net.response.PaginatedListResponse;
import com.railsreactor.moviedbapp.domain.models.Movie;

import io.reactivex.Single;

/**
 * @Author evgen on 18.02.2018.
 */

public interface MovieRepository {

    Single<PaginatedListResponse<Movie>> getMoviesListByPage(int pageIndex);
    Single<Movie> getMoviesDetails(int id);
}
