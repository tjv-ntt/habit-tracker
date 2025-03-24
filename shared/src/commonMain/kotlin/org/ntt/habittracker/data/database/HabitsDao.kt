package org.ntt.habittracker.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import org.ntt.habittracker.domain.model.Habit

@Dao
interface HabitsDao {
    @Upsert // Insert and update entities.
    suspend fun upsertHabit(habit: Habit)

    @Delete
    suspend fun deleteHabit(habit: Habit)

    @Query("SELECT * FROM habits")
    fun getAllHabits(): List<Habit>
}