package com.marina.notes.di

import android.content.Context
import androidx.room.Room
import com.marina.notes.data.NotesDao
import com.marina.notes.data.NotesDataBase
import com.marina.notes.data.NotesRepositoryImpl
import com.marina.notes.domain.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    companion object {
        @Singleton
        @Provides
        fun provideDatabase(
            @ApplicationContext context: Context
        ): NotesDataBase {
            return Room.databaseBuilder(
                context = context,
                klass = NotesDataBase::class.java,
                name = "notes.db"
            ).fallbackToDestructiveMigration(dropAllTables = true).build()
        }

        @Singleton
        @Provides
        fun provideNotesDao(
            database: NotesDataBase
        ): NotesDao {
            return database.notesDao()
        }
    }

    @Singleton
    @Binds
    fun bindsNoteRepository(
        impl: NotesRepositoryImpl
    ): NoteRepository
}
