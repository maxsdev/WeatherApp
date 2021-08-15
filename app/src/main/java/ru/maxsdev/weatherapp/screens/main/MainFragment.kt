package ru.maxsdev.weatherapp.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.maxsdev.domain.model.CurrentWeather
import ru.maxsdev.domain.model.TodayForecast
import ru.maxsdev.domain.model.WeekForecast
import ru.maxsdev.weatherapp.App
import ru.maxsdev.weatherapp.R
import ru.maxsdev.weatherapp.base.BaseMvpFragment
import ru.maxsdev.weatherapp.databinding.FragmentMainBinding
import ru.maxsdev.weatherapp.screens.main.adapters.TodayForecastAdapter
import ru.maxsdev.weatherapp.screens.main.adapters.WeekForecastAdapter

class MainFragment : BaseMvpFragment<FragmentMainBinding>(), IMainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    private val todayAdapter = TodayForecastAdapter()
    private val weekAdapter = WeekForecastAdapter()

    override fun inflate(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.todayForecast.adapter = todayAdapter
        binding.weekForecast.adapter = weekAdapter
    }

    override fun showCurrent(weather: CurrentWeather) {
        binding.location.text = weather.location
        binding.temperature.text = getString(R.string.temperature_template_i, weather.temperature)
        binding.conditionText.text = weather.condition
        binding.feelsLike.text =
            getString(R.string.feels_like_template, weather.feelsLike.toString())
    }

    override fun showTodayForecast(todayForecast: TodayForecast) {
        binding.date.text = getString(R.string.today_date_template, todayForecast.date)
        todayAdapter.updateForecast(todayForecast)
    }

    override fun showWeekForecast(weekForecast: WeekForecast) {
        weekAdapter.updateForecast(weekForecast)
    }

    @ProvidePresenter
    fun providePresenter(): MainPresenter =
        App.instance
            .appComponent
            .getMainPresenter()

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
