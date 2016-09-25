package com.github.jaccek.weatherapp.utils.contract;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by jacek on 9/25/16.
 */

public class ViewBaseActivity<PresenterType extends PresenterBase> extends AppCompatActivity
{
    private PresenterType mPresenter;

    public void setPresenter(PresenterType pPresenter)
    {
        mPresenter = pPresenter;
    }

    public PresenterType getPresenter()
    {
        return mPresenter;
    }
}
