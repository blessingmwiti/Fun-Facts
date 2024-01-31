package com.blessingmwiti.funfacts.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.blessingmwiti.funfacts.data.UserDataUiEvents
import com.blessingmwiti.funfacts.data.UserInputScreenState

class  UserInputViewModel: ViewModel() {

    var uiState = mutableStateOf(UserInputScreenState())
    fun onEvent(event: UserDataUiEvents) {
        when(event) {
            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(animalSelected = event.animal)
            }
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(nameEntered = event.name)
            }
        }
    }
}