package com.geektech.testdsl.domain.use_case

import com.geektech.testdsl.domain.repository.NoteRepo
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(private val noteRepo: NoteRepo) {

    fun getAllNote() = noteRepo.getAllNotes()

}