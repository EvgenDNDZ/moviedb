package com.railsreactor.moviedbapp.di;

import android.app.Application;
import android.content.res.Resources;

import com.google.gson.Gson;
import com.railsreactor.moviedbapp.domain.executor.PostExecutionThread;
import com.railsreactor.moviedbapp.domain.executor.TaskExecutor;
import com.railsreactor.moviedbapp.domain.executor.UIThread;
import com.railsreactor.moviedbapp.domain.executor.UseCaseExecutor;
import com.railsreactor.moviedbapp.presentation.main.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    Gson provideGson(){
        return new Gson();
    }

    @Provides
    @Singleton
    Resources provideResources(Application application) {
        return application.getResources();
    }

    @Provides
    @Singleton
    static UseCaseExecutor provideUseCaseExecutor(TaskExecutor taskExecutor) {
        return taskExecutor;
    }

    @Provides
    @Singleton
    static PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    Class<MainActivityViewModel> provideMainActivityViewModelClass() {
        return MainActivityViewModel.class;
    }

}
