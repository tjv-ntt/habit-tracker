import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import org.ntt.habittracker.core.presentation.AppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitHomeScreen() {
	val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
	Scaffold(
		modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
		topBar = { AppBar() }
	) { innerPadding ->
		androidx.compose.material3.Text(
			modifier = Modifier.padding(innerPadding),
			text = "List Tiles Placeholder"
		)
	}
}