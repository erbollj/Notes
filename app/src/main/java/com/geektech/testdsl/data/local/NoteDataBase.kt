package com.geektech.testdsl.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.testdsl.data.model.NoteDto

@Database(entities = [NoteDto::class], version = 3, exportSchema = false)
abstract class NoteDataBase : RoomDatabase() {
    abstract fun dao(): NoteDao
}