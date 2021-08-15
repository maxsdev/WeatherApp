package ru.maxsdev.weatherapp.screens.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.maxsdev.domain.model.DayForecast
import ru.maxsdev.domain.model.WeekForecast
import ru.maxsdev.weatherapp.R
import ru.maxsdev.weatherapp.databinding.ItemWeekForecastBinding

class WeekForecastAdapter : RecyclerView.Adapter<WeekForecastVH>() {

    private val forecast = WeekForecast()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekForecastVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemWeekForecastBinding.inflate(layoutInflater, parent, false)
        return WeekForecastVH(binding)
    }

    override fun onBindViewHolder(holder: WeekForecastVH, position: Int) {
        if (position > forecast.size - 1) {
            throw IndexOutOfBoundsException("Forecast size = ${forecast.size}, but position = $position")
        }
        holder.bind(forecast[position])
    }

    override fun getItemCount() = forecast.size

    fun updateForecast(weekForecast: WeekForecast) {
        forecast.clear()
        forecast.addAll(weekForecast)
        notifyDataSetChanged() // TODO Use DiffUtil
    }
}

class WeekForecastVH constructor(
    private val binding: ItemWeekForecastBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(dayForecast: DayForecast) {
        val context = binding.root.context
        binding.temperatureDay.text = context.getString(R.string.temperature_template_i, dayForecast.temperatureDay)
        binding.temperatureNight.text = context.getString(R.string.temperature_template_i, dayForecast.temperatureNight)
        binding.dayOfWeek.text = dayForecast.dayOfWeek
        binding.date.text = dayForecast.date
    }
}
