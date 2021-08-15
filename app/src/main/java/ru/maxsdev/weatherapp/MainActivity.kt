package ru.maxsdev.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.maxsdev.weatherapp.screens.main.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, MainFragment.newInstance())
            .commitAllowingStateLoss()
    }
}
