package ru.maxsdev.weatherapp.screens.main

import ru.maxsdev.domain.model.CurrentWeather
import ru.maxsdev.domain.model.TodayForecast
import ru.maxsdev.domain.model.WeekForecast

interface IMainInteractor {
    suspend fun requestCurrentWeather(): CurrentWeather
    suspend fun requestTodayForecast(): TodayForecast
    suspend fun requestWeekForecast(): WeekForecast
}
