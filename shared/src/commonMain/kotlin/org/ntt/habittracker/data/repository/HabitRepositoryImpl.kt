package org.ntt.habittracker.data.repository

import org.ntt.habittracker.data.database.HabitsDatabase
import org.ntt.habittracker.data.datasource.HabitLocalDataSource
import org.ntt.habittracker.domain.model.Habit

class HabitRepositoryImpl (private val repository: HabitLocalDataSource): HabitRepository {
    override suspend fun getAllHabits(): List<Habit> = repository.getAllHabits()
    override suspend fun deleteHabit(habit: Habit) = repository.deleteHabit(habit)
    override suspend fun upsertHabit(habit: Habit) = repository.upsertHabit(habit)
}