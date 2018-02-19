package com.railsreactor.moviedbapp.domain.interactor;

import com.railsreactor.moviedbapp.domain.executor.PostExecutionThread;
import com.railsreactor.moviedbapp.domain.executor.UseCaseExecutor;
import com.railsreactor.moviedbapp.domain.interactor.base.SingleUseCase;
import com.railsreactor.moviedbapp.domain.models.Movie;
import com.railsreactor.moviedbapp.domain.repository.MovieRepository;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * @author Evgeny Kubay on 2/18/18.
 */

public class GetMoviesDetailsUseCase extends SingleUseCase<Movie, Integer> {

    private final MovieRepository movieRepository;

    @Inject
    public GetMoviesDetailsUseCase(UseCaseExecutor useCaseExecutor, PostExecutionThread postExecutionThread, MovieRepository movieRepository) {
        super(useCaseExecutor, postExecutionThread);
        this.movieRepository = movieRepository;
    }


    @Override
    protected Single<Movie> buildSingle(Integer params) {
        return this.movieRepository.getMoviesDetails(params);
    }
}
