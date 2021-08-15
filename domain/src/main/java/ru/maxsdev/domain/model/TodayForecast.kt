package ru.maxsdev.domain.model

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class TodayForecast @JvmOverloads constructor(
    val date: String = LocalDate.now().format(DateTimeFormatter.ISO_DATE),
    src: List<HourForecast> = arrayListOf()
) : ArrayList<HourForecast>(src)
