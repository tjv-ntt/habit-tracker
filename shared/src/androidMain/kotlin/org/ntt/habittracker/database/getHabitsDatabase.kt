package org.ntt.habittracker.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

fun getHabitsDatabase(context: Context): HabitsDatabase {
    val dbFile = context.getDatabasePath("habits.db")
    return Room.databaseBuilder<HabitsDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}