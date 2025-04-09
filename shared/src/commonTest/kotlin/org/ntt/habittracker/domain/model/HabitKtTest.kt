package org.ntt.habittracker.domain.model

import org.koin.core.context.stopKoin
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HabitKtTest {

	@AfterTest
	fun tearDown() {
		stopKoin()
	}

@Test
	fun habitCreatedSuccessfully() {
		val habit = Habit(id = 1, name = "Valid Habit", completed = false)
		assertTrue(habit.id == 1)
		assertTrue(habit.name == "Valid Habit")
		assertFalse(habit.completed)
	}
}