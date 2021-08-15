package ru.maxsdev.domain.response

import com.google.gson.annotations.SerializedName

data class LocationResponse constructor(
    val name: String,
    val region: String,
    val country: String,
    @SerializedName("lat")
    val latitude: Float,
    @SerializedName("lon")
    val longitude: Float,
    @SerializedName("tz_id")
    val timeZone: String,
    @SerializedName("localtime")
    val localTime: String,
    @SerializedName("localtime_epoch")
    val localTimeEpoch: Long
)
