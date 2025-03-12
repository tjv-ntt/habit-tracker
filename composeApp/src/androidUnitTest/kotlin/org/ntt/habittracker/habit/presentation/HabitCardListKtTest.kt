package org.ntt.habittracker.habit.presentation

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HabitCardListKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val text = composeTestRule.onNodeWithContentDescription("Habit List")

    @Test
    fun listIsDisplayed() {
        composeTestRule.setContent {
            HabitCardList(modifier = Modifier)
        }

        text.assertIsDisplayed()
    }
}