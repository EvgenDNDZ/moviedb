package com.railsreactor.moviedbapp.utils;

import io.reactivex.functions.Consumer;

/**
 * @author Evgeny Kubay on 2/18/18.
 */

public interface PlainConsumer<T> extends Consumer<T> {
    /**
     * Consume the given value.
     * @param t the value
     */
    @Override
    void accept(T t);
}
