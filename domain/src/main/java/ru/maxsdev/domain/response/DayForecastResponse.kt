package ru.maxsdev.domain.response

import com.google.gson.annotations.SerializedName

data class DayForecastResponse constructor(
    val date: String, // YYYY-MM-DD
    val day: DayForecastDayResponse,
    @SerializedName("hour")
    val forecastByHours: List<HourForecastResponse>
)
