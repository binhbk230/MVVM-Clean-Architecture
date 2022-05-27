package com.bstudio.domain.usecase.note

import com.bstudio.data.entity.NoteEntity
import com.bstudio.data.repository.NoteDBRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NoteUseCaseImp(private val noteDBRepository: NoteDBRepository) : NoteUseCase{

    override suspend fun insertNote(note: NoteEntity) {
        noteDBRepository.insertNote(note)
    }

    override fun getAllNote(): Flow<List<NoteEntity>> {
        return flow {
            emit(noteDBRepository.getAllNote())
        }
    }

}