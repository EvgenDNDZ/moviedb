package com.railsreactor.moviedbapp.data.exceptions;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.railsreactor.moviedbapp.R;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.HttpException;

/**
 * @author Evgeny Kubay on 2/17/18.
 */

@Singleton
public class ErrorMessageFactory {

    private final Context context;
    private final Gson gson;

    @Inject
    public ErrorMessageFactory(Application context, Gson gson) {
        this.context = context;
        this.gson = gson;
    }

    /**
     * Creates a String representing an error message.
     *
     * @param throwable An exception used as a condition to retrieve the correct error message.
     * @return {@link String} an error message.
     */
    public String create(Throwable throwable) {
        String message = this.context.getString(R.string.unknown_error);
        try {
            if (throwable instanceof HttpException) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
