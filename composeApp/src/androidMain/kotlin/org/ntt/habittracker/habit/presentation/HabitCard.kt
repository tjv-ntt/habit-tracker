package org.ntt.habittracker.habit.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import org.ntt.habittracker.database.Habit

@Composable
fun HabitCard(modifier: Modifier, habit: Habit) {
    val checkedState = remember { mutableStateOf(false) }
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                modifier = Modifier.semantics { contentDescription = "Habit Checkbox" },
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
            Text(modifier = Modifier.semantics { contentDescription = "Habit Text" },
                text = habit.name,
                style = MaterialTheme.typography.titleLarge)
        }
    }
}