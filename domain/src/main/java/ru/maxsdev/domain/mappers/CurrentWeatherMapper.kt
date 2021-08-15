package ru.maxsdev.domain.mappers

import ru.maxsdev.domain.model.*
import ru.maxsdev.domain.response.CurrentWeatherResponse
import ru.maxsdev.domain.response.DayForecastResponse
import ru.maxsdev.domain.response.FullForecastResponse
import ru.maxsdev.domain.response.HourForecastResponse
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

fun CurrentWeatherResponse.mapToCurrentWeather(): CurrentWeather {
    return CurrentWeather(
        temperature = current.temperatureC.toInt(),
        feelsLike = current.feelsLike.toInt(),
        condition = current.condition.text,
        isDay = current.isDay > 0,
        location = location.name
    )
}

fun FullForecastResponse.mapToTodayForecast(): TodayForecast {
    val day = forecast
        .forecastDay
        .firstOrNull()
        ?: throw IllegalStateException("Empty forecast list")
    val date = getUserFriendlyDate(day.date)
    return day.forecastByHours
        .map { it.mapToHourForecast() }
        .let { TodayForecast(date, it) }
}

fun FullForecastResponse.mapToWeekForecast(): WeekForecast {
    return forecast
        .forecastDay
        .map { it.mapToDayForecast() }
        .let { WeekForecast(it) }
}

private fun HourForecastResponse.mapToHourForecast() = HourForecast(
    time = getTimeFromDateTime(dateTime),
    conditionIconUrl = condition.icon,
    temperature = temperatureC.toInt()
)

private fun DayForecastResponse.mapToDayForecast() = DayForecast(
    dayOfWeek = getDayOfWeekFromDate(date),
    date = getUserFriendlyDate(date),
    conditionIconUrl = day.condition.icon,
    temperatureDay = day.maxTemperature.toInt(),
    temperatureNight = day.minTemperature.toInt()
)

private fun getTimeFromDateTime(date: String): String {
    val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
    val accessor = dateTimeFormatter.parse(date)
    return LocalDateTime.from(accessor).toLocalTime().format(timeFormatter)
}

private fun getDayOfWeekFromDate(date: String): String {
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val dayOfWeekFormatter = DateTimeFormatter.ofPattern("EEEE")
    val accessor = dateFormatter.parse(date)
    return LocalDate.from(accessor).format(dayOfWeekFormatter)
        .replaceFirstChar { it.titlecase(Locale.getDefault()) }
}

private fun getUserFriendlyDate(date: String): String {
    val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val friendlyDateFormatter = DateTimeFormatter.ofPattern("d MMMM")
    val accessor = dateFormatter.parse(date)
    return LocalDate.from(accessor).format(friendlyDateFormatter)
}
