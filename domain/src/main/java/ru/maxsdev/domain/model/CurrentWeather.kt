package ru.maxsdev.domain.model

data class CurrentWeather constructor(
    val temperature: Int,
    val feelsLike: Int,
    val condition: String,
    val isDay: Boolean,
    val location: String
)
