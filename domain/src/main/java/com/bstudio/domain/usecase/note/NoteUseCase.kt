package com.bstudio.domain.usecase.note

import com.bstudio.data.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteUseCase {
    suspend fun insertNote(note: NoteEntity)
    fun getAllNote(): Flow<List<NoteEntity>>
}