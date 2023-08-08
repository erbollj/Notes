package com.geektech.testdsl.data.local

import androidx.room.*
import com.geektech.testdsl.data.model.NoteDto

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(noteDto: NoteDto)

    @Query("SELECT * FROM note")
    suspend fun getAllNotes(): List<NoteDto>

    @Delete
    suspend fun deleteNote(noteDto: NoteDto)

    @Update
    suspend fun updateNote(noteDto: NoteDto)

}