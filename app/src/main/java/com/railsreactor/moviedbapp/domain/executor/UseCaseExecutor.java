package com.railsreactor.moviedbapp.domain.executor;

import java.util.concurrent.Executor;

/**
 * * Every implementation of this interface will execute the
 * {@link_ UseCaseArgumentLess} out of the UI thread.
 *
 * @author Evgeny Kubay on 2/17/18.
 */

public interface UseCaseExecutor extends Executor {
}
