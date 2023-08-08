package com.geektech.testdsl.data.repo

import com.geektech.testdsl.base.BaseRepository
import com.geektech.testdsl.data.local.NoteDao
import com.geektech.testdsl.data.model.toDomain
import com.geektech.testdsl.data.utils.Resource
import com.geektech.testdsl.domain.model.NoteDomain
import com.geektech.testdsl.domain.model.toDto
import com.geektech.testdsl.domain.repository.NoteRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepoImpl @Inject constructor(private val noteDao: NoteDao) : NoteRepo, BaseRepository() {

    override fun addNote(noteDomain: NoteDomain): Flow<Resource<Unit>> = doRequest {
        noteDao.addNote(noteDomain.toDto())
    }

    override fun getAllNotes(): Flow<Resource<List<NoteDomain>>> = doRequest {
        noteDao.getAllNotes().map { it.toDomain() }
    }

    override fun updateNote(noteDomain: NoteDomain): Flow<Resource<Unit>> = doRequest {
        noteDao.updateNote(noteDomain.toDto())
    }

    override fun deleteNote(noteDomain: NoteDomain): Flow<Resource<Unit>> = doRequest {
        noteDao.deleteNote(noteDomain.toDto())
    }

}