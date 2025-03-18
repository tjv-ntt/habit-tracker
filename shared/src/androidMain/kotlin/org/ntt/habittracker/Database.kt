package org.ntt.habittracker

import android.content.Context
import androidx.room.Room

fun getDatabaseBuilder(context: Context) = with(context) {
    val dbFile = applicationContext.getDatabasePath("room_android.db")
    Room.databaseBuilder<AppDatabase>(
        context = applicationContext,
        name = dbFile.absolutePath
    )
}