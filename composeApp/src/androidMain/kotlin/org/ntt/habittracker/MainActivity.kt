package org.ntt.habittracker

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.ntt.habittracker.database.getHabitsDatabase


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = getHabitsDatabase(applicationContext).getHabitsDao()

        setContent {
            App(habitsDao = dao)
        }
    }
}

class HabitTrackerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HabitTrackerApp)
            modules(appModule)
        }
    }
}