package org.ntt.habittracker.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import org.ntt.habittracker.data.database.HabitsDatabase

fun getDatabaseBuilder(context: Context): HabitsDatabase {
    val dbFile = context.getDatabasePath("habits.db")
    return Room.databaseBuilder<HabitsDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}