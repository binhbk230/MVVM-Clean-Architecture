package com.bstudio.data.service

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bstudio.data.entity.NoteEntity

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    suspend fun getAll() : List<NoteEntity>

    @Insert
    suspend fun insertNote(vararg notes: NoteEntity)

    @Delete
    suspend fun deleteNote(vararg notes: NoteEntity)
}