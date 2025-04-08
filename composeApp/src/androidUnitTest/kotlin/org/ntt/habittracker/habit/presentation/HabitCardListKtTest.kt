package org.ntt.habittracker.habit.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.ntt.habittracker.domain.model.Habit
import org.ntt.habittracker.viewmodel.HomeViewModel
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HabitCardListKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val text = composeTestRule.onNodeWithContentDescription("Habit List")
	private val testHomeViewModel = HomeViewModel().apply {
		allHabits.value = listOf(
			Habit(id = 1, name = "Test Habit", completed = false),
			Habit(id = 2, name = "Another Test Habit", completed = false)
		)
	}

    @Test
    fun listIsDisplayed() {
	    composeTestRule.setContent {
		    HabitCardList(viewModel = testHomeViewModel)
	    }

        text.assertIsDisplayed()
    }
}