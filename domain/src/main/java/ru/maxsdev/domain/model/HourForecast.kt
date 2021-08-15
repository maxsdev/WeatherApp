package ru.maxsdev.domain.model

data class HourForecast constructor(
    val time: String,
    val conditionIconUrl: String,
    val temperature: Int
)
