package org.ntt.habittracker.database

import androidx.room.Room
import androidx.room.RoomDatabase
import org.ntt.habittracker.data.database.HabitsDatabase
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): RoomDatabase.Builder<HabitsDatabase> {
    val dbFile = NSHomeDirectory() + "/habits.db"
    return Room.databaseBuilder<HabitsDatabase>(
        name = dbFile,
    )
}