package com.geektech.testdsl.domain.use_case

import com.geektech.testdsl.domain.model.NoteDomain
import com.geektech.testdsl.domain.repository.NoteRepo
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val noteRepo: NoteRepo) {

    fun deleteNote(noteDomain: NoteDomain) = noteRepo.deleteNote(noteDomain)

}