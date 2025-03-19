package org.ntt.habittracker.database

import androidx.room.Room
import androidx.room.RoomDatabase
import platform.Foundation.NSHomeDirectory

fun getHabitsDatabase(): RoomDatabase.Builder<HabitsDatabase> {
    val dbFile = NSHomeDirectory() + "/habits.db"
    return Room.databaseBuilder<HabitsDatabase>(
        name = dbFile,
    )
}