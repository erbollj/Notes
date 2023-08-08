package com.geektech.testdsl.presentation.model


data class NoteUI(
    val id: Int = DEFAULT_ID,
    val title: String,
    val description: String
) {
    companion object {
        const val DEFAULT_ID = 0
    }
}

