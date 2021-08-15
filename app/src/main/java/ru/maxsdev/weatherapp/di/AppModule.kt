package ru.maxsdev.weatherapp.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.maxsdev.domain.repositories.IWeatherRepository
import ru.maxsdev.domain.repositories.WeatherRepository
import ru.maxsdev.weatherapp.BuildConfig
import ru.maxsdev.weatherapp.screens.main.IMainInteractor
import ru.maxsdev.weatherapp.screens.main.MainInteractor
import javax.inject.Named

@Module
abstract class AppModule {

    @Binds
    abstract fun bindMainInteractor(impl: MainInteractor): IMainInteractor

    @Binds
    abstract fun bindWeatherService(impl: WeatherRepository): IWeatherRepository

    companion object {
        @Provides
        @Named(WeatherRepository.API_KEY_NAMED)
        fun provideApiKey(): String = BuildConfig.API_KEY
    }
}
