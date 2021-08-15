package ru.maxsdev.domain.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.maxsdev.domain.repositories.IWeatherService

@Module
class DomainModule {

    @Provides
    fun provideWeatherService(): IWeatherService {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // Logging всегда последний.
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IWeatherService::class.java)
    }


    companion object {
        private const val BASE_URL = "https://api.weatherapi.com/v1/"
    }
}
