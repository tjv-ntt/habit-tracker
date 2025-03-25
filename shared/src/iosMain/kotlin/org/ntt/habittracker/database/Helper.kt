package org.ntt.habittracker.database

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.ntt.habittracker.data.repository.HabitRepository

class HabitRepositoryHelper: KoinComponent {

    private val habitRepository: HabitRepository by inject()
    fun getHabitRepository(): HabitRepository = habitRepository

}