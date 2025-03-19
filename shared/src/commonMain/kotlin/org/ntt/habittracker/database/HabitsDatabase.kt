package org.ntt.habittracker.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Database(entities = [Habit::class], version = 1)
@ConstructedBy(HabitsDatabaseConstructor::class)
abstract class HabitsDatabase : RoomDatabase() {
    abstract fun getHabitsDao(): HabitsDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object HabitsDatabaseConstructor : RoomDatabaseConstructor<HabitsDatabase> {
    override fun initialize(): HabitsDatabase
}