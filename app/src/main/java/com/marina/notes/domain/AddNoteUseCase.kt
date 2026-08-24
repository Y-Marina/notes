package com.marina.notes.domain

import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(
        title: String,
        content: String
    ) {
        repository.addNote(
            title = title,
            content = content,
            isPinned = false,
            updateAt = System.currentTimeMillis()
        )
    }
}
