package ru.maxsdev.weatherapp.screens.main

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.maxsdev.domain.model.CurrentWeather
import ru.maxsdev.domain.model.TodayForecast
import ru.maxsdev.domain.model.WeekForecast

@StateStrategyType(AddToEndSingleStrategy::class)
interface IMainView : MvpView {
    fun showCurrent(weather: CurrentWeather)
    fun showTodayForecast(todayForecast: TodayForecast)
    fun showWeekForecast(weekForecast: WeekForecast)
}
