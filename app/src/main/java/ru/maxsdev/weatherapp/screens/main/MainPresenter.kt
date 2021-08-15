package ru.maxsdev.weatherapp.screens.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val interactor: IMainInteractor
) : MvpPresenter<IMainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        presenterScope.launch {
            val currentWeatherDeferred = async { interactor.requestCurrentWeather() }
            val todayForecastDeferred = async { interactor.requestTodayForecast() }
            val weekForecastDeferred = async { interactor.requestWeekForecast() }

            currentWeatherDeferred.await().let { currentWeather ->
                withContext(Dispatchers.Main) {
                    viewState.showCurrent(currentWeather)
                }
            }
            todayForecastDeferred.await().let { todayForecast ->
                withContext(Dispatchers.Main) {
                    viewState.showTodayForecast(todayForecast)
                }
            }
            weekForecastDeferred.await().let { weekForecast ->
                withContext(Dispatchers.Main) {
                    viewState.showWeekForecast(weekForecast)
                }
            }
        }
    }
}
