package com.marina.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [NoteDbModel::class, ContentItemDbModel::class],
    version = 3,
    exportSchema = false
)
abstract class NotesDataBase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}
