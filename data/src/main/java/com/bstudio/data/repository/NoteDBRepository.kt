package com.bstudio.data.repository

import com.bstudio.data.entity.NoteEntity
import com.bstudio.data.service.NoteDao

class NoteDBRepository(private val noteDao: NoteDao) {

    suspend fun getAllNote(): List<NoteEntity>{
        return noteDao.getAll()
    }

    suspend fun insertNote(note: NoteEntity) {
        return noteDao.insertNote(note)
    }
}