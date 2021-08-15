package ru.maxsdev.domain.response

import com.google.gson.annotations.SerializedName

data class ForecastResponse constructor(
    @SerializedName("forecastday")
    val forecastDay: List<DayForecastResponse>
)
