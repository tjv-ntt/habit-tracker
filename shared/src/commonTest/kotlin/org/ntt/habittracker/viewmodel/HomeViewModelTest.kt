package org.ntt.habittracker.viewmodel

import dev.mokkery.answering.returns
import dev.mokkery.answering.throws
import dev.mokkery.everySuspend
import dev.mokkery.mock
import kotlinx.coroutines.runBlocking
import org.ntt.habittracker.domain.model.Habit
import org.ntt.habittracker.domain.usecase.DeleteHabitUseCase
import org.ntt.habittracker.domain.usecase.GetAllHabitsUseCase
import org.ntt.habittracker.domain.usecase.UpsertHabitUseCase
import kotlin.test.Test
import kotlin.test.assertEquals

class HomeViewModelTest {

	private val homeViewModel: HomeViewModel = HomeViewModel()
	private val getAllHabitsUseCase: GetAllHabitsUseCase = mock()
	private val upsertHabitUseCase: UpsertHabitUseCase = mock()
	private val deleteHabitUseCase: DeleteHabitUseCase = mock()

	@Test
	fun getAllHabits_emitsHabitsList() = runBlocking {
		val habits = listOf(Habit(id = 1, name = "Exercise", completed = false))
		everySuspend {
			getAllHabitsUseCase.execute()
		} returns habits

		homeViewModel.getAllHabits()

		assertEquals(habits, homeViewModel.allHabits.value)
	}

	@Test
	fun upsertHabit_addsNewHabit() = runBlocking {
		val newHabit = Habit(id = 2, name = "Read", completed = false)
		val updatedHabits = listOf(
			Habit(id = 1, name = "Exercise", completed = false),
			newHabit
		)
		everySuspend { upsertHabitUseCase.execute(newHabit) } returns Unit
		everySuspend { getAllHabitsUseCase.execute() } returns updatedHabits

		homeViewModel.upsertHabit(newHabit)

		assertEquals(updatedHabits, homeViewModel.allHabits.value)
	}

	@Test
	fun deleteHabit_removesExistingHabit() = runBlocking {
		val habitToDelete = Habit(id = 1, name = "Exercise", completed = false)
		val remainingHabits = emptyList<Habit>()
		everySuspend { deleteHabitUseCase.execute(habitToDelete) } returns Unit
		everySuspend { getAllHabitsUseCase.execute() } returns remainingHabits

		homeViewModel.deleteHabit(habitToDelete)

		assertEquals(remainingHabits, homeViewModel.allHabits.value)
	}

	@Test
	fun getAllHabits_handlesException() = runBlocking {
		everySuspend { getAllHabitsUseCase.execute() } throws Exception("Error fetching habits")

		homeViewModel.getAllHabits()

		assertEquals(emptyList<Habit>(), homeViewModel.allHabits.value)
	}
}