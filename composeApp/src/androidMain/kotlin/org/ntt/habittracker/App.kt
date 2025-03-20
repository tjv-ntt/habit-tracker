package org.ntt.habittracker

import HabitHomeScreen
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.ntt.habittracker.database.HabitsDao

@Composable
@Preview
fun App(habitsDao: HabitsDao) {
   HabitHomeScreen(habitsDao)
   }
