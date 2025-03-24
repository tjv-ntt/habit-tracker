package org.ntt.habittracker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.ntt.habittracker.domain.model.Habit

@Database(entities = [Habit::class], version = 1)
//@ConstructedBy(HabitsDatabaseConstructor::class)
abstract class HabitsDatabase : RoomDatabase() {
    abstract fun getDao(): HabitsDao
}

// The Room compiler generates the `actual` implementations.
//@Suppress("NO_ACTUAL_FOR_EXPECT")
//expect object HabitsDatabaseConstructor : RoomDatabaseConstructor<HabitsDatabase> {
//    override fun initialize(): HabitsDatabase
//}