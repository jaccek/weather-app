package com.github.jaccek.weatherapp.utils.contract;

/**
 * Created by jacek on 10/16/16.
 */
public interface PresenterBase<ViewType, RouterType>
{
    void init(ViewType pView, RouterType pRouter);
}
