package com.bstudio.di

import androidx.room.Room
import androidx.room.migration.Migration
import com.bstudio.data.database.AppDatabase
import com.bstudio.data.service.NoteDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { Room.databaseBuilder(androidContext(), AppDatabase::class.java, "notedb")
        .fallbackToDestructiveMigration()
        .build() }
    single { provideNoteDao(get()) }
}

fun provideNoteDao(db: AppDatabase) : NoteDao{
    return db.noteDao()
}


