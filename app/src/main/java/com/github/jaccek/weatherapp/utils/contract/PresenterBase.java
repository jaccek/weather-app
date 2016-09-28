package com.github.jaccek.weatherapp.utils.contract;

/**
 * Created by jacek on 9/25/16.
 */

public interface PresenterBase<ViewType, RouterType>
{
    void init(ViewType pView, RouterType pRouter);
}
