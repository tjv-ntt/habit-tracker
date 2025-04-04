import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.koinViewModel
import org.ntt.habittracker.core.presentation.AppBar
import org.ntt.habittracker.domain.model.Habit
import org.ntt.habittracker.habit.presentation.HabitCardList
import org.ntt.habittracker.viewmodel.HomeViewModel
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitHomeScreen() {
	val viewModel = koinViewModel<HomeViewModel>()
	val showModal = remember { mutableStateOf(false) }

	viewModel.getAllHabits()

	val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
	Scaffold(
		modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
		topBar = { AppBar() }
	) {
		Box(modifier = Modifier.padding(it.calculateTopPadding())) {
			Column(modifier = Modifier.fillMaxSize()) {
				HabitCardList(viewModel)
				Spacer(modifier = Modifier.weight(1f))
				Row {
					Spacer(modifier = Modifier.weight(1f))
					IconButton(onClick = { showModal.value = true },
						modifier = Modifier
							.clip(CircleShape)
							.background(Color.LightGray)){
						Icon(
							imageVector = Icons.Filled.Add,
							contentDescription = "Add"
						)
					}
				}
			}
			if (showModal.value) {
				ModalBottomSheet(onDismissRequest = { showModal.value = false }) {
					Box(modifier = Modifier.fillMaxSize()) {
						AddHabitView(
							isPresented = showModal,
							onSubmit = { habit ->
								viewModel.upsertHabit(habit)
							}
						)
					}
				}
			}
		}
	}
}

@Composable
fun AddHabitView(
	isPresented: MutableState<Boolean>,
	onSubmit: (Habit) -> Unit
) {
	var habitName = remember { mutableStateOf("") }
	val habit = remember { Habit(id = generateInt32FromUUID(), name = "", completed = false) }

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp)
	) {
		Text("Add Habit",
			modifier = Modifier.align(Alignment.CenterHorizontally),
			fontSize = 20.sp
		)
		TextField(
			value = habitName.value,
			onValueChange = { habitName.value = it },
			label = { Text("Enter Habit Name") },
			modifier = Modifier
				.fillMaxWidth()
				.padding(vertical = 8.dp)
		)
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Button(onClick = { isPresented.value = false }) {
				Text("Cancel")
			}
			Button(onClick = {
				val newHabit = habit.copy(name = habitName.value)
				onSubmit(newHabit)
				isPresented.value = false
			}) {
				Text("Submit")
			}
		}
	}
}

fun generateInt32FromUUID(): Int {
	val uuid = UUID.randomUUID()
	val uuidString = uuid.toString()
	val hashValue = uuidString.hashCode()
	return hashValue
}