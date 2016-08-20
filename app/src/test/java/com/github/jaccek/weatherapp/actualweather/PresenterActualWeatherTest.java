package com.github.jaccek.weatherapp.actualweather;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;

/**
 * Created by jacek on 8/20/16.
 */
public class PresenterActualWeatherTest
{
    PresenterActualWeather mPresenter;
    @Mock
    ContractActualWeather.Router mRouter;

    @Rule
    public MockitoRule mMockitoRule = MockitoJUnit.rule();

    @Before
    public void init()
    {
        mPresenter = new PresenterActualWeather(mRouter);
    }

    @Test
    public void testOnCityClicked()
    {
        mPresenter.onCityClicked();
        verify(mRouter).startChangeCityActivity(mPresenter);
    }
}