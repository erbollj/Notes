package com.geektech.testdsl.domain.repository

import com.geektech.testdsl.data.utils.Resource
import com.geektech.testdsl.domain.model.NoteDomain
import kotlinx.coroutines.flow.Flow

interface NoteRepo {

    fun addNote(noteDomain: NoteDomain): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<NoteDomain>>>

    fun updateNote(noteDomain: NoteDomain): Flow<Resource<Unit>>

    fun deleteNote(noteDomain: NoteDomain): Flow<Resource<Unit>>

//    CRUD
//    C - create
//    R - read
//    U - update
//    D - delete
}