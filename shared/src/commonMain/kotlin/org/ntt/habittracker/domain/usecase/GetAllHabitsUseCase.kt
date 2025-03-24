package org.ntt.habittracker.domain.usecase

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.ntt.habittracker.data.repository.HabitRepository

class GetAllHabitsUseCase : KoinComponent {
    private val habitRepository: HabitRepository by inject()
    suspend fun execute() = habitRepository.getAllHabits()
}