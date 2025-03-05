package org.ntt.habittracker.habit.presentation

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HabitCardKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val checkbox = composeTestRule.onNodeWithContentDescription("Habit Checkbox")
    private val text = composeTestRule.onNodeWithText("Habit Text")

    @Test
    fun checkboxInitiallyUnchecked() {
        composeTestRule.setContent {
            HabitCard(modifier = Modifier)
        }

        checkbox.assertIsDisplayed()
        checkbox.assertIsOff()
    }

    @Test
    fun toggleCheckbox() {
        composeTestRule.setContent {
            HabitCard(modifier = Modifier)
        }

        checkbox.performClick()
        checkbox.assertIsOn()
    }

    @Test
    fun textIsDisplayed() {
        composeTestRule.setContent {
            HabitCard(modifier = Modifier)
        }

        text.assertIsDisplayed()
    }
}