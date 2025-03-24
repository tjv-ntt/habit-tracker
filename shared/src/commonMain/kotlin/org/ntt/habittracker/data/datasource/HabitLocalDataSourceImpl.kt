package org.ntt.habittracker.data.datasource

import org.ntt.habittracker.domain.model.Habit
import org.ntt.habittracker.data.database.HabitsDatabase

class HabitLocalDataSourceImpl (private val habitsDatabase: HabitsDatabase): HabitLocalDataSource {
    override suspend fun getAllHabits(): List<Habit> = habitsDatabase.getDao().getAllHabits()
    override suspend fun deleteHabit(habit: Habit) = habitsDatabase.getDao().deleteHabit(habit)
    override suspend fun upsertHabit(habit: Habit) = habitsDatabase.getDao().upsertHabit(habit)
}