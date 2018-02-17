package com.railsreactor.moviedbapp.di;

import android.app.Application;

import com.railsreactor.moviedbapp.MovieDBApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * @author Evgeny Kubay on 2/17/18.
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuildersModule.class,
        NetModule.class,
        DataModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application app);
        AppComponent build();
    }

    void inject(MovieDBApp movieDBApp);
}
