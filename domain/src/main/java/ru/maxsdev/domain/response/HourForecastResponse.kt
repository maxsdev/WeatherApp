package ru.maxsdev.domain.response

import com.google.gson.annotations.SerializedName

data class HourForecastResponse constructor(
    @SerializedName("time")
    val dateTime: String,
    @SerializedName("temp_c")
    val temperatureC: Float,
    val condition: ConditionResponse
)
