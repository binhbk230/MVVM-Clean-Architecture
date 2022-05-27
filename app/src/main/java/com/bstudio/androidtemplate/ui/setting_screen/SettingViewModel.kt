package com.bstudio.androidtemplate.ui.setting_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bstudio.androidtemplate.common.Response
import com.bstudio.data.entity.NoteEntity
import com.bstudio.data.response.UserInfoResponse
import com.bstudio.domain.usecase.note.NoteUseCase
import com.bstudio.domain.usecase.userinfo.UserInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SettingViewModel(private val useCase: NoteUseCase): ViewModel() {

    private val _noteList = MutableStateFlow<Response<List<NoteEntity>>>(Response.loading())
    val noteList = _noteList.asStateFlow()

    fun insertNote(note: NoteEntity) {
        viewModelScope.launch {
            useCase.insertNote(note)
        }
    }

    fun getAllNote() {
        viewModelScope.launch {
            useCase.getAllNote()
                .onStart {
                    _noteList.emit(Response.loading())
                }.catch {
                    _noteList.emit(Response.error(it))
                }.collect {
                    _noteList.emit(Response.success(it))
                }
        }
    }

}