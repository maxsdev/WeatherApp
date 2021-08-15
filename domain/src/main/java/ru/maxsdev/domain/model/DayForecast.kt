package ru.maxsdev.domain.model

data class DayForecast constructor(
    val dayOfWeek: String,
    val date: String,
    val conditionIconUrl: String,
    val temperatureDay: Int,
    val temperatureNight: Int
)
