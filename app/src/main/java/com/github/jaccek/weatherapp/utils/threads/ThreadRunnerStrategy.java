package com.github.jaccek.weatherapp.utils.threads;

/**
 * Created by jacek on 8/20/16.
 */
public interface ThreadRunnerStrategy
{
    void executeInBackground(Runnable pRunnable);
    void executeInMainThread(Runnable pRunnable);
}
