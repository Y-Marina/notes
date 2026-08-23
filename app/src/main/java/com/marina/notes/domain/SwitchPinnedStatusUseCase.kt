package com.marina.notes.domain

class SwitchPinnedStatusUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(noteId: Int) {
        repository.switchPinnedStatus(noteId)
    }
}