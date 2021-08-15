package ru.maxsdev.weatherapp.screens.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.maxsdev.domain.model.HourForecast
import ru.maxsdev.domain.model.TodayForecast
import ru.maxsdev.weatherapp.R
import ru.maxsdev.weatherapp.databinding.ItemTodayForecastBinding

class TodayForecastAdapter : RecyclerView.Adapter<TodayForecastVH>() {

    private val forecast = TodayForecast()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayForecastVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodayForecastBinding.inflate(layoutInflater, parent, false)
        return TodayForecastVH(binding)
    }

    override fun onBindViewHolder(holder: TodayForecastVH, position: Int) {
        if (position > forecast.size - 1) {
            throw IndexOutOfBoundsException("Forecast size = ${forecast.size}, but position = $position")
        }
        holder.bind(forecast[position])
    }

    override fun getItemCount() = forecast.size

    fun updateForecast(todayForecast: TodayForecast) {
        forecast.clear()
        forecast.addAll(todayForecast)
        notifyDataSetChanged() // TODO Use DiffUtil
    }
}

class TodayForecastVH constructor(
    private val binding: ItemTodayForecastBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(hourForecast: HourForecast) {
        val context = binding.root.context
        binding.time.text = hourForecast.time
        binding.forecast.text = context.getString(R.string.temperature_template_i, hourForecast.temperature)
    }
}
