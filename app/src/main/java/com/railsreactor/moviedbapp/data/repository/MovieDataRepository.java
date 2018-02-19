package com.railsreactor.moviedbapp.data.repository;

import com.railsreactor.moviedbapp.BuildConfig;
import com.railsreactor.moviedbapp.data.net.MovieDbApi;
import com.railsreactor.moviedbapp.data.net.response.PaginatedListResponse;
import com.railsreactor.moviedbapp.domain.models.Movie;
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

    private final MovieDbApi movieDBApi;
    private final Locale locale;

    @Inject
    public MovieDataRepository(MovieDbApi movieDBApi, Locale locale) {
        this.movieDBApi = movieDBApi;
        this.locale = locale;
    }

    @Override
    public Single<PaginatedListResponse<Movie>> getMoviesListByPage(int pageIndex) {
        return this.movieDBApi.getMoviesListByPage(BuildConfig.THEMOVIEDB_API_KEY, locale.getDisplayLanguage(), pageIndex, null);
    }

    @Override
    public Single<Movie> getMoviesDetails(int id) {
        return this.movieDBApi.getMovieDetailsById(id, BuildConfig.THEMOVIEDB_API_KEY, locale.getDisplayLanguage(), null);
    }
}

