import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import org.koin.androidx.compose.koinViewModel
import org.ntt.habittracker.core.presentation.AppBar
import org.ntt.habittracker.habit.presentation.HabitCardList
import org.ntt.habittracker.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitHomeScreen() {
	val viewModel = koinViewModel<HomeViewModel>()

	viewModel.getAllHabits()

	val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
	Scaffold(
		modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
		topBar = { AppBar() }
	) {
		Box(modifier = Modifier.padding(it.calculateTopPadding())){
			HabitCardList(viewModel)
		}

	}
}