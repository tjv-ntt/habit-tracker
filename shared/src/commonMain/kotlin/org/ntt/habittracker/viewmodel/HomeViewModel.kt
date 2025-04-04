package org.ntt.habittracker.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.ntt.habittracker.domain.model.Habit
import org.ntt.habittracker.domain.usecase.DeleteHabitUseCase
import org.ntt.habittracker.domain.usecase.GetAllHabitsUseCase
import org.ntt.habittracker.domain.usecase.UpsertHabitUseCase

class HomeViewModel : ViewModel(), KoinComponent {
    private val getAllHabitsUseCase: GetAllHabitsUseCase by inject()
    private val upsertHabitUseCase: UpsertHabitUseCase by inject()
    private val deleteHabitUseCase: DeleteHabitUseCase by inject()

    private val _allHabits = mutableStateOf(listOf<Habit>())
    val allHabits = _allHabits

    fun getAllHabits() = viewModelScope.launch {
        try {
            _allHabits.value = getAllHabitsUseCase.execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun upsertHabit(habit: Habit) = viewModelScope.launch {
        try {
            upsertHabitUseCase.execute(habit)
            _allHabits.value = getAllHabitsUseCase.execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun deleteHabit(habit: Habit) = viewModelScope.launch {
        try {
            deleteHabitUseCase.execute(habit)
            _allHabits.value = getAllHabitsUseCase.execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}