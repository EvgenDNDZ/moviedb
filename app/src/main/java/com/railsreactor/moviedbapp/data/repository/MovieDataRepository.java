package com.railsreactor.moviedbapp.data.repository;

import com.railsreactor.moviedbapp.BuildConfig;
import com.railsreactor.moviedbapp.data.net.MovieDBApi;
import com.railsreactor.moviedbapp.data.net.response.MoviesListResponse;
import com.railsreactor.moviedbapp.domain.repository.MovieRepository;

import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

@Singleton
public class MovieDataRepository implements MovieRepository {

    private final MovieDBApi movieDBApi;

    @Inject
    public MovieDataRepository(MovieDBApi movieDBApi) {
        this.movieDBApi = movieDBApi;
    }

    @Override
    public Single<MoviesListResponse> getMoviesListByPage(int pageIndex) {
        return this.movieDBApi.getMoviesListByPage(BuildConfig.THEMOVIEDB_API_KEY, Locale.getDefault().getDisplayLanguage(), pageIndex);
    }
}
