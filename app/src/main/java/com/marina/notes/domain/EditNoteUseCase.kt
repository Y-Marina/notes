package com.marina.notes.domain

import javax.inject.Inject

class EditNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.editNote(
            note.copy(updatedAt = System.currentTimeMillis())
        )
    }
}
