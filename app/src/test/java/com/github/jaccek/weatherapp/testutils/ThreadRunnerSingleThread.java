package com.github.jaccek.weatherapp.testutils;

import com.github.jaccek.weatherapp.utils.threads.ThreadRunnerStrategy;

/**
 * Mock of {@link ThreadRunnerStrategy}. It runs all {@link Runnable}s in actual thread.
 */
public class ThreadRunnerSingleThread implements ThreadRunnerStrategy
{
    @Override
    public void executeInBackground(Runnable pRunnable)
    {
        pRunnable.run();
    }

    @Override
    public void executeInMainThread(Runnable pRunnable)
    {
        pRunnable.run();
    }
}
