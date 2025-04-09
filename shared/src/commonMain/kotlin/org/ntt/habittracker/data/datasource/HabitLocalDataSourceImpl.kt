package org.ntt.habittracker.data.datasource

import org.ntt.habittracker.data.database.HabitsDao
import org.ntt.habittracker.domain.model.Habit

class HabitLocalDataSourceImpl (private val habitsDao: HabitsDao): HabitLocalDataSource {
    override suspend fun getAllHabits(): List<Habit> = habitsDao.getAllHabits()
    override suspend fun deleteHabit(habit: Habit) = habitsDao.deleteHabit(habit)
    override suspend fun upsertHabit(habit: Habit) = habitsDao.upsertHabit(habit)
}