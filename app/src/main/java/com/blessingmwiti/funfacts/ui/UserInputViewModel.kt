package com.blessingmwiti.funfacts.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.blessingmwiti.funfacts.data.UserDataUiEvents
import com.blessingmwiti.funfacts.data.UserInputScreenState

class  UserInputViewModel: ViewModel() {


    companion object{
        const val TAG = "UserInputViewModel"
    }

    var uiState = mutableStateOf(UserInputScreenState())
    fun onEvent(event: UserDataUiEvents) {
        when(event) {
            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(animalSelected = event.animal)
                Log.d(TAG, "onEvent: AnimalSelected->> ")
                Log.d(TAG, "${uiState.value}")
            }
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(nameEntered = event.name)
                Log.d(TAG, "onEvent: UserNameEntered->> ")
                Log.d(TAG, "${uiState.value}")
            }
        }
    }
}