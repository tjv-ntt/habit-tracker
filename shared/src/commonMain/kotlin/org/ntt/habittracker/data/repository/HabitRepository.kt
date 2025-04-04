package org.ntt.habittracker.data.repository

import org.ntt.habittracker.domain.model.Habit

interface HabitRepository {
    suspend fun getAllHabits(): List<Habit>
    suspend fun deleteHabit(habit: Habit)
    suspend fun upsertHabit(habit: Habit)
}