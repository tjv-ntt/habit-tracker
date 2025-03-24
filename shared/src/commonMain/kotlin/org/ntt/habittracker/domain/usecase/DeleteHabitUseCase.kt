package org.ntt.habittracker.domain.usecase

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.ntt.habittracker.data.repository.HabitRepository
import org.ntt.habittracker.domain.model.Habit

class DeleteHabitUseCase : KoinComponent {
    private val habitRepository: HabitRepository by inject()
    suspend fun execute(habit: Habit) = habitRepository.deleteHabit(habit)
}