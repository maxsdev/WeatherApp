package ru.maxsdev.domain.response

data class FullForecastResponse constructor(
    val locationResponse: LocationResponse,
    val current: CurrentResponse,
    val forecast: ForecastResponse
)
