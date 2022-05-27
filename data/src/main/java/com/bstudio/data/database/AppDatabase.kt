package com.bstudio.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bstudio.data.entity.NoteEntity
import com.bstudio.data.service.NoteDao

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDao() : NoteDao
}