package com.github.jaccek.weatherapp.utils.threads;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jacek on 9/28/16.
 */

public class ThreadRunnerStrategyImpl implements ThreadRunnerStrategy
{
    private static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final int KEEP_ALIVE_TIME = 1;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private ThreadPoolExecutor mThreadExecutor;
    private Handler mHandler;

    public ThreadRunnerStrategyImpl()
    {
        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>();
        mHandler = new Handler(Looper.getMainLooper());
        mThreadExecutor = new ThreadPoolExecutor(NUMBER_OF_CORES,
                NUMBER_OF_CORES,
                KEEP_ALIVE_TIME,
                KEEP_ALIVE_TIME_UNIT,
                queue);
    }

    @Override
    public void executeInBackground(Runnable pRunnable)
    {
        mThreadExecutor.execute(pRunnable);
    }

    @Override
    public void executeInMainThread(Runnable pRunnable)
    {
        mHandler.post(pRunnable);
    }
}
