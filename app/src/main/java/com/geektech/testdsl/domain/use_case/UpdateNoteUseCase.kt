package com.geektech.testdsl.domain.use_case

import com.geektech.testdsl.domain.model.NoteDomain
import com.geektech.testdsl.domain.repository.NoteRepo
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(private val noteRepo: NoteRepo) {

    fun updateNote(noteDomain: NoteDomain) = noteRepo.updateNote(noteDomain)

}