package org.ntt.habittracker

import androidx.room.Room
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder() = Room.databaseBuilder<AppDatabase>(
    name = NSHomeDirectory() + "/room_ios.db",
    factory =  { AppDatabase::class.instantiateImpl() }
)