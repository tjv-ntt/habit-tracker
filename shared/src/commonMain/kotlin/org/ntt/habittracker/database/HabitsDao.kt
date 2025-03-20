package org.ntt.habittracker.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitsDao {
    @Upsert // Insert and update entities.
    suspend fun upsert(habit: Habit)

    @Delete
    suspend fun delete(habit: Habit)

    @Query("SELECT * FROM habits")
    fun getAll(): Flow<List<Habit>>
}