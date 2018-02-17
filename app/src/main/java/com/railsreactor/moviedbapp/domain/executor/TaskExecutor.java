package com.railsreactor.moviedbapp.domain.executor;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Decorated {@link ThreadPoolExecutor}
 *
 * @author Evgeny Kubay on 2/17/18.
 */

@Singleton
public class TaskExecutor implements UseCaseExecutor {

    private static final int INITIAL_POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;

    // The amount of time an idle thread will wait before terminating.
    private static final int KEEP_ALIVE_TIME = 10;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private final ThreadPoolExecutor threadPoolExecutor;

    @Inject
    public TaskExecutor() {
        this.threadPoolExecutor = new ThreadPoolExecutor(
                INITIAL_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                KEEP_ALIVE_TIME_UNIT,
                new LinkedBlockingQueue<>(),
                new TaskThreadFactory()
        );
    }

    @Override
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new IllegalArgumentException("Runnable to execute cannot be null");
        }
        this.threadPoolExecutor.execute(runnable);
    }

    private static class TaskThreadFactory implements ThreadFactory {
        private static final String THREAD_NAME = "guyanataxi";
        private int counter = 0;

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, THREAD_NAME + counter++);
        }
    }
}
