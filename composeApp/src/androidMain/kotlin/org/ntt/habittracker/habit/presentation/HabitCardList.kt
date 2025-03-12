package org.ntt.habittracker.habit.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun HabitCardList(modifier: Modifier) {
    LazyColumn(
        modifier = Modifier.semantics { contentDescription = "Habit List" },
        contentPadding = PaddingValues(
            start = 16.dp,
            top = 96.dp,
            end = 16.dp,
            ),
    ) {
        items(3) {
            HabitCard(modifier = Modifier.padding(vertical = 8.dp))
        }
    }
}