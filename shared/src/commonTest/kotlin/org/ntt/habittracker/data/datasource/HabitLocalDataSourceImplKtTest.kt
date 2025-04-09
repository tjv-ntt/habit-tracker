package org.ntt.habittracker.data.datasource
import dev.mokkery.answering.returns
import dev.mokkery.everySuspend
import dev.mokkery.mock
import dev.mokkery.verifySuspend
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.ntt.habittracker.data.database.HabitsDao
import org.ntt.habittracker.domain.model.Habit

class HabitLocalDataSourceImplTest {

    private val mockDao = mock<HabitsDao>{}

    private val dataSource = HabitLocalDataSourceImpl(mockDao)

    @Test
    fun getAllHabits_returnsAllHabitsFromDatabase() = runBlocking {
        val expectedHabits = listOf(
            Habit(name = "Habit1", completed = false),
            Habit(name = "Habit2", completed = false)
        )
        everySuspend { mockDao.getAllHabits() } returns expectedHabits

        val result = dataSource.getAllHabits()

        assertEquals(expectedHabits, result)
    }

    @Test
    fun deleteHabit_deletesHabitFromDatabase() = runBlocking {
        val habitToDelete = Habit(name = "HabitToDelete", completed = false)

        everySuspend { mockDao.deleteHabit(habitToDelete) } returns Unit

        dataSource.deleteHabit(habitToDelete)

        verifySuspend { mockDao.deleteHabit(habitToDelete) }
    }

    @Test
    fun upsertHabit_insertsOrUpdatesHabitInDatabase() = runBlocking {
        val habitToUpsert = Habit(name = "HabitToUpsert", completed = false)

        everySuspend { mockDao.upsertHabit(habitToUpsert) } returns Unit

        dataSource.upsertHabit(habitToUpsert)

        verifySuspend { mockDao.upsertHabit(habitToUpsert) }
    }

    @Test
    fun getAllHabits_returnsEmptyListWhenNoHabitsExist() = runBlocking {
        everySuspend { mockDao.getAllHabits() } returns emptyList()

        val result = dataSource.getAllHabits()

        assertTrue(result.isEmpty())
    }
}