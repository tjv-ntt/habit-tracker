package org.ntt.habittracker.habit.presentation

import HabitHomeScreen
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class HabitHomeScreenKtTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun habitHomeScreen_displaysHelloWorld() {
        composeTestRule.setContent {
            HabitHomeScreen()
        }
        composeTestRule.onNodeWithText("Hello World!").assertIsDisplayed()
    }
}