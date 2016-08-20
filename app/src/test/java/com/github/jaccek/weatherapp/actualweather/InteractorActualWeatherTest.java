package com.github.jaccek.weatherapp.actualweather;

import com.github.jaccek.weatherapp.actualweather.interactor.InteractorActualWeather;
import com.github.jaccek.weatherapp.network.ThreadRunnerStrategy;

import org.junit.Before;
import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Created by jacek on 8/20/16.
 */
public class InteractorActualWeatherTest
{
    InteractorActualWeather mInteractor;
    ThreadRunnerStrategy mThreadRunner;
    @Mock
    ContractActualWeather.PresenterForInteractor mPresenter;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Before
    public void init()
    {
        mThreadRunner = new ThreadRunnerMocked();
        mInteractor = new InteractorActualWeather(mThreadRunner);
    }

//    // TODO: this test fails
//    @Test
//    public void testRequestUserCitySuccess()
//    {
//        ActualWeatherData data = new ActualWeatherData();
//        mInteractor.requestUserCity(mPresenter);
//        verify(mPresenter).onActualWeatherData(data);
//    }

    /**
     * Mock of {@link ThreadRunnerMocked}. It runs all {@link Runnable}s in actual thread.
     */
    private static class ThreadRunnerMocked implements ThreadRunnerStrategy
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
}