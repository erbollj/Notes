package com.geektech.testdsl.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.geektech.testdsl.domain.model.NoteDomain

@Entity(tableName = "note")
data class NoteDto(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    val id: Int,
    val title: String,
    val description: String
)

fun NoteDto.toDomain() = NoteDomain(id, title, description)

