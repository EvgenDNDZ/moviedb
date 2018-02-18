package com.railsreactor.moviedbapp.domain.interactor;

import com.railsreactor.moviedbapp.data.net.response.MoviesListResponse;
import com.railsreactor.moviedbapp.domain.executor.PostExecutionThread;
import com.railsreactor.moviedbapp.domain.executor.UseCaseExecutor;
import com.railsreactor.moviedbapp.domain.interactor.base.SingleUseCase;
import com.railsreactor.moviedbapp.domain.repository.MovieRepository;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * @Author evgen on 18.02.2018.
 */

public class GetMoviesListUseCase extends SingleUseCase<MoviesListResponse,Integer> {

    private final MovieRepository movieRepository;

    @Inject
    public GetMoviesListUseCase(UseCaseExecutor useCaseExecutor, PostExecutionThread postExecutionThread, MovieRepository movieRepository) {
        super(useCaseExecutor, postExecutionThread);
        this.movieRepository = movieRepository;
    }


    @Override
    protected Single<MoviesListResponse> buildSingle(Integer params) {
        return this.movieRepository.getMoviesListByPage(params);
    }
}
