package org.ntt.habittracker.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.ntt.habittracker.domain.model.Habit
import org.ntt.habittracker.domain.usecase.GetAllHabitsUseCase

class HomeViewModel : ViewModel(), KoinComponent {
    private val getAllHabitsUseCase: GetAllHabitsUseCase by inject()
//    private val deleteNoteUseCase: DeleteNoteUseCase by inject()

    private val _allHabits = mutableStateOf(listOf<Habit>())
    val allHabits = _allHabits

//    private val _showDialog = mutableStateOf(false)
//    val showDialog = _showDialog

//    private val _noteId = mutableStateOf(0L)
//    val noteId = _noteId

    fun getAllHabits() = viewModelScope.launch {
        try {
            _allHabits.value = getAllHabitsUseCase.execute()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

//    fun deleteNotes(noteId: Long) = viewModelScope.launch {
//        _showDialog.value = false
//        try {
//            deleteNoteUseCase.execute(noteId)
//            _noteId.value = 0
//            _allNotes.value = getAllNotesUseCase.execute()
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//    }

//    fun showAlertDialog(noteId: Long) {
//        _noteId.value = noteId
//        _showDialog.value = true
//    }
//
//    fun dismissAlertDialog() {
//        _noteId.value = 0
//        _showDialog.value = false
//    }
}