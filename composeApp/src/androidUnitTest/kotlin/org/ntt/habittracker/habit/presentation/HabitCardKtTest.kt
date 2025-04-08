package org.ntt.habittracker.habit.presentation

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.GlobalContext.stopKoin
import org.ntt.habittracker.domain.model.Habit
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HabitCardKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val checkbox = composeTestRule.onNodeWithContentDescription("Habit Checkbox")
    private val text = composeTestRule.onNodeWithText("Habit Text")
  //  private val deleteButton = composeTestRule.onNodeWithContentDescription("Delete Habit Button")

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun checkboxInitiallyUnchecked() {
        composeTestRule.setContent {
            HabitCard(
                modifier = Modifier,
                habit = Habit(
                    id = 1,
                    name = "Test Habit",
                    completed = false
                ),
                deleteHabit = { }
            )
        }

        checkbox.assertIsDisplayed()
        checkbox.assertIsOff()
    }

    @Test
    fun toggleCheckbox() {
        composeTestRule.setContent {
            HabitCard(
                modifier = Modifier,
                habit = Habit(
                    id = 1,
                    name = "Test Habit",
                    completed = true
                ),
                deleteHabit = { }
            )
        }

        checkbox.performClick()
        checkbox.assertIsOn()
    }

    @Test
    fun textIsDisplayed() {
        composeTestRule.setContent {
            HabitCard(
                modifier = Modifier,
                habit = Habit(
                    id = 1,
                    name = "Habit Text",
                    completed = false
                ),
                deleteHabit = { }
            )
        }

        text.assertIsDisplayed()
    }

    //TODO: Start of deleteHabit button tests
//    @Test
//    fun deleteHabitButtonIsDisplayed() {
//        composeTestRule.setContent {
//            HabitCard(
//                modifier = Modifier,
//                habit = Habit(
//                    id = 1,
//                    name = "Test Habit",
//                    completed = false
//                ),
//                deleteHabit = { }
//            )
//        }
//
//        deleteButton.assertIsDisplayed()
//    }
}