package org.ntt.habittracker.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

fun getHabitsDatabase(): HabitsDatabase {
    val dbFile = NSHomeDirectory() + "/habits.db"
    return Room.databaseBuilder<HabitsDatabase>(
        name = dbFile,
        factory = { HabitsDatabase::class.instantiateImpl() }
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}