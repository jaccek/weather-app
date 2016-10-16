package com.github.jaccek.weatherapp.activities;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.github.jaccek.weatherapp.activities.ActivityChooseCity;
import com.github.jaccek.weatherapp.contracts.ContractChooseCity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.verify;

/**
 * Created by jacek on 10/15/16.
 */
@RunWith(AndroidJUnit4.class)
public class ActivityChooseCityTest
{
    private ActivityChooseCity mActivity;
    private ContractChooseCity.Presenter mPresenter;

    @Rule
    public IntentsTestRule<ActivityChooseCity> mActivityRule = new IntentsTestRule<>(ActivityChooseCity.class);

    @Before
    public void init()
    {
        mActivity = mActivityRule.getActivity();
        mPresenter = mActivity.mPresenter;
    }

    @Test
    public void onCreate()
    {
        verify(mPresenter).init(mActivity, mActivity);
        verify(mPresenter).onCreate();
    }
}