package com.railsreactor.moviedbapp.domain.repository;

import com.railsreactor.moviedbapp.data.net.response.MoviesListResponse;
import com.railsreactor.moviedbapp.domain.models.MovieDetails;

import io.reactivex.Single;

/**
 * @Author evgen on 18.02.2018.
 */

public interface MovieRepository {

    Single<MoviesListResponse> getMoviesListByPage(int pageIndex);
    Single<MovieDetails> getMoviesDetails(int id);
}
