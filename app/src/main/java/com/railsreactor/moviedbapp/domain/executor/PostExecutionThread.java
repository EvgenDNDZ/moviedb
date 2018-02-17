package com.railsreactor.moviedbapp.domain.executor;


import io.reactivex.Scheduler;

/**
 * Thread abstraction created to change the execution context from any thread to any other thread.
 * Should be used to encapsulate a UI Thread, since some job will be done in background, an
 * implementation of this interface will change context and update the UI.
 *
 * @author Evgeny Kubay on 2/17/18.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}
