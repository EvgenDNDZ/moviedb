package com.railsreactor.moviedbapp.domain.repository;

import com.railsreactor.moviedbapp.data.net.response.MoviesListResponse;

import io.reactivex.Single;

/**
 * @Author evgen on 18.02.2018.
 */

public interface MovieRepository {

    Single<MoviesListResponse> getMoviesListByPage(int pageIndex);
}
