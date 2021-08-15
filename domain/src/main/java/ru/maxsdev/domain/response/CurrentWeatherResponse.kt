package ru.maxsdev.domain.response

data class CurrentWeatherResponse constructor(
    val location: LocationResponse,
    val current: CurrentResponse
)
