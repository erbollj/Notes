package com.geektech.testdsl.domain.model

import com.geektech.testdsl.data.model.NoteDto
import com.geektech.testdsl.presentation.model.NoteUI

data class NoteDomain(
    val id: Int = DEFAULT_ID,
    val title: String,
    val description: String
) {
    companion object {
        const val DEFAULT_ID = 0
    }
}

fun NoteDomain.toDto() = NoteDto(id, title, description)
fun NoteDomain.toUI() = NoteUI(id, title, description)
