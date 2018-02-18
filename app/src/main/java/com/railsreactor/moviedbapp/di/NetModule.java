package com.railsreactor.moviedbapp.di;


import com.google.gson.Gson;
import com.railsreactor.moviedbapp.BuildConfig;
import com.railsreactor.moviedbapp.data.net.MovieDBApi;
import com.railsreactor.moviedbapp.domain.executor.UseCaseExecutor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

@Module
public class NetModule {

    @Provides
    @Singleton
    static OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient().newBuilder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(loggingInterceptor);
        }

        httpClientBuilder.readTimeout(60, TimeUnit.SECONDS);
        httpClientBuilder.connectTimeout(120, TimeUnit.SECONDS);

        httpClientBuilder.addNetworkInterceptor(chain -> {
            Request originalRequest = chain.request();
            Request.Builder requestBuilder = originalRequest.newBuilder()
                    .header("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .method(originalRequest.method(), originalRequest.body());
            return chain.proceed(requestBuilder.build());
        });

        return httpClientBuilder.build();
    }

    @Provides
    @Singleton
    static Retrofit provideRestClient(Gson gson, OkHttpClient okHttpClient,
                                      UseCaseExecutor useCaseExecutor) {

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    MovieDBApi provideMovieDBApi(Retrofit retrofit) {
        return retrofit.create(MovieDBApi.class);
    }
}
