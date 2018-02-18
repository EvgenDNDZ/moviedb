package com.railsreactor.moviedbapp.di;

import com.railsreactor.moviedbapp.data.repository.MovieDataRepository;
import com.railsreactor.moviedbapp.domain.repository.MovieRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

@Module
public class DataModule {

    @Provides
    @Singleton
    MovieRepository provideMovieRepository(MovieDataRepository movieDataRepository) {
        return movieDataRepository;
    }

}
