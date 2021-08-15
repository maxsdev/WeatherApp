package ru.maxsdev.weatherapp.screens.main

import javax.inject.Inject

class MainInteractor @Inject constructor(
    private val apiService: ru.maxsdev.domain.repositories.IWeatherRepository
) : IMainInteractor {

    override suspend fun requestCurrentWeather() = apiService.getCurrentWeather()

    override suspend fun requestTodayForecast() = apiService.getTodayForecast()

    override suspend fun requestWeekForecast() = apiService.getWeekForecast()
}
