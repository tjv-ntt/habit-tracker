package org.ntt.habittracker.data.database

import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.mock
import dev.mokkery.verifySuspend
import kotlinx.coroutines.runBlocking
import org.ntt.habittracker.domain.model.Habit
import kotlin.test.Test
import kotlin.test.assertEquals

class HabitsDaoTest {

	private var mockHabitsDao = mock<HabitsDao>{}
	private val mockHabit = Habit(id = 1, name = "Exercise", completed = false)


	@Test
	 fun upsertHabit_savesOrUpdatesHabitSuccessfully() = runBlocking {
		everySuspend { mockHabitsDao.upsertHabit(mockHabit) } returns Unit

		mockHabitsDao.upsertHabit(mockHabit)

		verifySuspend { mockHabitsDao.upsertHabit(mockHabit) }
	}

	@Test
	fun deleteHabit_removesHabitSuccessfully() = runBlocking {
		everySuspend { mockHabitsDao.deleteHabit(mockHabit) } returns Unit

		mockHabitsDao.deleteHabit(mockHabit)

		verifySuspend { mockHabitsDao.deleteHabit(mockHabit) }
	}

	@Test
	fun getAllHabits_returnsListOfHabits() = runBlocking {
		val mockHabits = listOf(mockHabit)
		everySuspend { mockHabitsDao.getAllHabits() } returns mockHabits

		val result = mockHabitsDao.getAllHabits()

		assertEquals(mockHabits, result)
		verifySuspend { mockHabitsDao.getAllHabits() }
	}
}