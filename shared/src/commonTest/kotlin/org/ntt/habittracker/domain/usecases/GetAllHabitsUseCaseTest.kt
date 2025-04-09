package org.ntt.habittracker.domain.usecase

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.kotlin.mock
import org.ntt.habittracker.data.repository.HabitRepository

class GetAllHabitsUseCaseTest {

    private lateinit var habitRepository: HabitRepository
    private lateinit var getAllHabitsUseCase: GetAllHabitsUseCase

    @Before
    fun setUp() {
        habitRepository = mock()
        getAllHabitsUseCase = GetAllHabitsUseCase().apply {
            // Inject the mocked repository
            val field = this::class.java.getDeclaredField("habitRepository")
            field.isAccessible = true
            field.set(this, habitRepository)
        }
    }

    @Test
    fun `execute calls getAllHabits on HabitRepository`() = runBlocking {
        // Arrange
        `when`(habitRepository.getAllHabits()).thenReturn(emptyList())

        // Act
        getAllHabitsUseCase.execute()

        // Assert
        verify(habitRepository).getAllHabits()
    }
}