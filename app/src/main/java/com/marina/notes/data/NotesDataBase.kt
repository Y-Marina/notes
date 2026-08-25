package com.marina.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [NoteDbModel::class],
    version = 2,
    exportSchema = false
)
abstract class NotesDataBase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}
