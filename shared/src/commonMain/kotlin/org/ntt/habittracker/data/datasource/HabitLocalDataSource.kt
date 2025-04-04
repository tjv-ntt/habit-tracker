package org.ntt.habittracker.data.datasource

import org.ntt.habittracker.domain.model.Habit

interface HabitLocalDataSource {
        suspend fun getAllHabits(): List<Habit>
        suspend fun deleteHabit(habit: Habit)
        suspend fun upsertHabit(habit: Habit)
}