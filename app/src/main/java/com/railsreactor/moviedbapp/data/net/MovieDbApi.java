package com.railsreactor.moviedbapp.data.net;

import android.support.annotation.NonNull;

import com.railsreactor.moviedbapp.data.net.response.PaginatedListResponse;
import com.railsreactor.moviedbapp.domain.models.Movie;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

public interface MovieDbApi {

    /**
     * Get a list of upcoming movies in theatres.
     *
     * @param apiKey    Required. API access key.
     * @param language  Optional (default: <i>en-US</i>). Pass a ISO 639-1 value to display translated data for the fields
     *                  that support it or <i>null</i> to omit this parameter.
     * @param pageIndex Optional (default: <i>1</i>). Specify which page to query. Minimum: 1. Maximum: 1000. Pass
     *                  <i>null</i> to omit this parameter.
     * @param region    Optional. Specify a ISO 3166-1 code to filter release dates.
     *                  Must be uppercase. Pattern: ^[A-Z]{2}$
     *                  Pass <i>null</i> to omit this parameter.
     * @return Single that emits {@link PaginatedListResponse} or an error
     * @see <a href="API Documentation">https://developers.themoviedb.org/3/movies/get-upcoming</a>
     */

    @GET("movie/upcoming")
    Single<PaginatedListResponse<Movie>> getMoviesListByPage(
            @NonNull @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") Integer pageIndex,
            @Query("region") String region
    );

    /**
     * Get the primary information about a movie.
     *
     * @param apiKey   Required. API access key.
     * @param movieId  Required. The id of the movie in the database.
     * @param language Optional (default: <i>en-US</i>). Pass a ISO 639-1 value to display translated data for the fields
     *                 that support it or <i>null</i> to omit this parameter.
     * @param appendToResponse Append requests within the same namespace to the response. Pattern: ([\w]+)
     * @return Single that emits {@link Movie} or an error
     * * @see <a href="API Documentation">https://developers.themoviedb.org/3/movies/get-movie-details</a>
     */

    @GET("movie/{movie_id}")
    Single<Movie> getMovieDetailsById(
            @NonNull @Path("movie_id") int movieId,
            @NonNull @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("append_to_response") String appendToResponse
    );
}
