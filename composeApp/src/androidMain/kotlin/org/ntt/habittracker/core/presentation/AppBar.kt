package org.ntt.habittracker.core.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
	val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
		CenterAlignedTopAppBar(
			colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
			title = {
				androidx.compose.material3.Text(
					"Habit Tracker",
					maxLines = 1,
					overflow = TextOverflow.Ellipsis
				)
			},
			//TODO: implement actions menu after MVP
//			actions = {
//				IconButton(onClick = { /* do something */ }) {
//					Icon(
//						imageVector = Icons.Filled.Menu,
//						contentDescription = "Localized description"
//					)
//				}
//			},
			scrollBehavior = scrollBehavior,
		)
}