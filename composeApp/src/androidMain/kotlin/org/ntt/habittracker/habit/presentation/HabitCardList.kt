package org.ntt.habittracker.habit.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import org.ntt.habittracker.viewmodel.HomeViewModel


@Composable
fun HabitCardList(viewModel: HomeViewModel) {
//	val habits by habitsDao.getAll().collectAsState(initial = emptyList())
//	val scope = rememberCoroutineScope()

//	LaunchedEffect(true) {
//		val habitsList = listOf(
//			Habit(1, "Running", false),
//			Habit(2, "Reading", false),
//			Habit(3, "Meditation", false)
//		)
//		habitsList.forEach {
//			habitsDao.upsert(it)
//		}
//	}

	val habits = viewModel.allHabits.value

	if (habits.isEmpty().not()) {
		LazyColumn(
			modifier = Modifier.semantics { contentDescription = "Habit List" },
			contentPadding = PaddingValues(
				start = 16.dp,
				top = 96.dp,
				end = 16.dp,
			),
		) {
			items(habits) { habit ->
				HabitCard(
					modifier = Modifier.padding(vertical = 8.dp),
					habit = habit
				)
			}
		}
	} else {
		Box(modifier = Modifier.padding(bottom = 64.dp)) {
			Text("NO LIST :O")
		}
	}
}