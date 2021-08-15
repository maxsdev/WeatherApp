package ru.maxsdev.weatherapp.di

import dagger.Component
import ru.maxsdev.domain.di.DomainModule
import ru.maxsdev.weatherapp.screens.main.MainPresenter

@Component(modules = [AppModule::class, DomainModule::class])
interface AppComponent {

    fun getMainPresenter(): MainPresenter
}
