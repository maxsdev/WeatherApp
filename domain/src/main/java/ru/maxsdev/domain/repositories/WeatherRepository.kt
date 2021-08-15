package ru.maxsdev.domain.repositories

import ru.maxsdev.domain.mappers.mapToCurrentWeather
import ru.maxsdev.domain.mappers.mapToTodayForecast
import ru.maxsdev.domain.mappers.mapToWeekForecast
import ru.maxsdev.domain.model.CurrentWeather
import ru.maxsdev.domain.model.TodayForecast
import ru.maxsdev.domain.model.WeekForecast
import javax.inject.Inject
import javax.inject.Named

class WeatherRepository @Inject constructor(
    @Named(API_KEY_NAMED) private val apiKey: String,
    private val service: IWeatherService
) : IWeatherRepository {

    override suspend fun getCurrentWeather(): CurrentWeather {
        return service.getCurrentWeather(apiKey).mapToCurrentWeather()
    }

    override suspend fun getTodayForecast(): TodayForecast {
        return service.getTodayForecast(apiKey).mapToTodayForecast()
    }

    override suspend fun getWeekForecast(): WeekForecast {
        return service.getWeekForecast(apiKey).mapToWeekForecast()
    }

    companion object {
        const val API_KEY_NAMED = "API_KEY_NAMED"
    }
}
