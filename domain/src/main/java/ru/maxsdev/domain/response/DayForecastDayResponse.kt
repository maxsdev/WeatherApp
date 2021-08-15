package ru.maxsdev.domain.response

import com.google.gson.annotations.SerializedName

data class DayForecastDayResponse constructor(
    @SerializedName("maxtemp_c")
    val maxTemperature: Float,
    @SerializedName("mintemp_c")
    val minTemperature: Float,
    val condition: ConditionResponse
)
