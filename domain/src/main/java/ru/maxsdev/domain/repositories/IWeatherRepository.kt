package ru.maxsdev.domain.repositories

import ru.maxsdev.domain.model.CurrentWeather
import ru.maxsdev.domain.model.TodayForecast
import ru.maxsdev.domain.model.WeekForecast

interface IWeatherRepository {
    suspend fun getCurrentWeather(): CurrentWeather

    suspend fun getTodayForecast(): TodayForecast

    suspend fun getWeekForecast(): WeekForecast
}
