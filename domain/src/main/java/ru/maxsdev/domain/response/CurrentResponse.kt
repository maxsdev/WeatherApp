package ru.maxsdev.domain.response

import com.google.gson.annotations.SerializedName

data class CurrentResponse constructor(
    @SerializedName("temp_c")
    val temperatureC: Float,
    @SerializedName("temp_f")
    val temperatureF: Float,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Long,
    @SerializedName("is_day")
    val isDay: Int, // 1 - yes, 0 - no.
    val condition: ConditionResponse,
    @SerializedName("wind_dir")
    val windDirection: String,
    @SerializedName("wind_kph")
    val windKph: Float,
    @SerializedName("precip_mm")
    val precipitation: Float,
    val humidity: Int,
    val cloud: Int,
    @SerializedName("gust_kph")
    val gust: Float,
    @SerializedName("feelslike_c")
    val feelsLike: Float
)
