package com.github.jaccek.weatherapp.dagger;

import com.github.jaccek.weatherapp.contracts.ContractActualWeather;
import com.github.jaccek.weatherapp.dagger.ModuleActualWeather;

import org.mockito.Mockito;

import dagger.Module;

/**
 * Created by jacek on 9/26/16.
 */
@Module
public class TestModuleActualWeather extends ModuleActualWeather
{
    @Override
    ContractActualWeather.Presenter providePresenter(ContractActualWeather.Interactor pInteractor)
    {
        return Mockito.mock(ContractActualWeather.Presenter.class);
    }
}
