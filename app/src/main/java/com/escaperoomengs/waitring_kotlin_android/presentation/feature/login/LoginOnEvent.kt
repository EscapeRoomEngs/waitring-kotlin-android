package com.escaperoomengs.waitring_kotlin_android.presentation.feature.login

sealed class LoginOnEvent {
    data object SetCheckAuto : LoginOnEvent()
}