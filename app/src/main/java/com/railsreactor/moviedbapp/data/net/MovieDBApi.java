package com.railsreactor.moviedbapp.data.net;

import com.railsreactor.moviedbapp.data.net.response.MoviesListResponse;
import com.railsreactor.moviedbapp.domain.models.MovieDetails;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public interface MovieDBApi {

    @GET("movie/upcoming")
    Single<MoviesListResponse> getMoviesListByPage(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int pageIndex
    );

    @GET("movie/{movie_id}")
    Single<MovieDetails> getMovieDetailsById(@Path("movie_id") int id,
                                             @Query("api_key") String apiKey,
                                             @Query("language") String language);
}
