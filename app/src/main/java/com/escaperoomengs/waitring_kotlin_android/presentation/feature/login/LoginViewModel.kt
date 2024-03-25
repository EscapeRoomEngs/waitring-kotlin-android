package com.escaperoomengs.waitring_kotlin_android.presentation.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEvent(event: LoginOnEvent) {
        viewModelScope.launch {
            when (event) {
                is LoginOnEvent.SetCheckAuto -> setCheckAuto()
            }
        }
    }

    private fun setCheckAuto() =
        _uiState.update { it.copy(isAutoCheck = !it.isAutoCheck) }
}