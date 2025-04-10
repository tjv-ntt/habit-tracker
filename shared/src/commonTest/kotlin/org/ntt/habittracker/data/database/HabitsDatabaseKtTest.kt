package org.ntt.habittracker.data.database

import org.koin.core.context.stopKoin
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertNotNull

class HabitsDatabaseTest {

	@AfterTest
	fun tearDown() {
		stopKoin()
	}

	@Test
	fun shouldInitializeDatabaseSuccessfully() {
		val database = HabitsDatabaseConstructor.initialize()
		assertNotNull(database)
	}
}