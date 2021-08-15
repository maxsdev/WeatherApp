package ru.maxsdev.domain.repositories

import retrofit2.http.GET
import retrofit2.http.Query
import ru.maxsdev.domain.response.CurrentWeatherResponse
import ru.maxsdev.domain.response.FullForecastResponse

interface IWeatherService {

    @GET("current.json?q=auto:ip")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("lang") lang: String = "ru"
    ): CurrentWeatherResponse

    @GET("forecast.json?q=auto:ip")
    suspend fun getTodayForecast(
        @Query("key") apiKey: String,
        @Query("lang") lang: String = "ru"
    ): FullForecastResponse

    @GET("forecast.json?q=auto:ip")
    suspend fun getWeekForecast(
        @Query("key") apiKey: String,
        @Query("lang") lang: String = "ru",
        @Query("days") days: Int = 7
    ): FullForecastResponse
}
