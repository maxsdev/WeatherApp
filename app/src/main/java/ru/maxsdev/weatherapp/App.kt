package ru.maxsdev.weatherapp

import android.app.Application
import ru.maxsdev.weatherapp.di.AppComponent
import ru.maxsdev.weatherapp.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder().build()
    }

    companion object {
        lateinit var instance: App
    }
}
