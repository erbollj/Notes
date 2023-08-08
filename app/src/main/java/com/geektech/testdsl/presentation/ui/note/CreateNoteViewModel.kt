package com.geektech.testdsl.presentation.ui.note

import com.geektech.testdsl.base.BaseViewModel
import com.geektech.testdsl.domain.model.NoteDomain
import com.geektech.testdsl.domain.model.toUI
import com.geektech.testdsl.domain.use_case.AddNoteUseCase
import com.geektech.testdsl.domain.use_case.DeleteNoteUseCase
import com.geektech.testdsl.domain.use_case.GetAllNotesUseCase
import com.geektech.testdsl.domain.use_case.UpdateNoteUseCase
import com.geektech.testdsl.presentation.model.NoteUI
import com.geektech.testdsl.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateNoteViewModel @Inject constructor(
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val getAllNotesUseCase: GetAllNotesUseCase
) : BaseViewModel() {

    private val _addNote = MutableStateFlow<UiState<Unit>>(UiState.Loading())
    val addNote = _addNote.asStateFlow()

    private val _getAllNotes = MutableStateFlow<UiState<List<NoteUI>>>(UiState.Loading())
    val getAllNotes = _getAllNotes.asStateFlow()

    private val _delete = MutableStateFlow<UiState<Unit>>(UiState.Loading())
    val delete = _delete.asStateFlow()

    fun addNote(noteDomain: NoteDomain) {
        addNoteUseCase.addNote(noteDomain).subscribe(
            {
                _addNote.value = UiState.Error(it ?: "Unknown message")
            },
            {
                _addNote.value = UiState.Loading()
            },
            {
                if (it != null)
                    _addNote.value = UiState.Success(it)
            }
        )
    }

    fun getAllNotes() {
        getAllNotesUseCase.getAllNote().subscribe(
            {
                _getAllNotes.value = UiState.Error(it ?: "Unknown message")
            },
            {
                _getAllNotes.value = UiState.Loading()
            },
            { list ->
                if (list != null)
                    _getAllNotes.value = UiState.Success(list.map { it.toUI() })
            }
        )
    }

    fun delete(noteDomain: NoteDomain) {
        deleteNoteUseCase.deleteNote(noteDomain).subscribe(
            {
                _delete.value = UiState.Error(it ?: "Unknown message")
            },
            {
                _delete.value = UiState.Loading()
            },
            {
                if (it != null) {
                    _delete.value = UiState.Success(it)
                }
            }
        )
    }

}