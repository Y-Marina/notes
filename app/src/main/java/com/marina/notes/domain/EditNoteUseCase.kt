package com.marina.notes.domain

class EditNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.editNote(
            note.copy(updatedAt = System.currentTimeMillis())
        )
    }
}