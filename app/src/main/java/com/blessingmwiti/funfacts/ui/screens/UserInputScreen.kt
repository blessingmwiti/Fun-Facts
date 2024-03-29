package com.blessingmwiti.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blessingmwiti.funfacts.R
import com.blessingmwiti.funfacts.data.UserDataUiEvents
import com.blessingmwiti.funfacts.ui.AnimalCard
import com.blessingmwiti.funfacts.ui.ButtonComponent
import com.blessingmwiti.funfacts.ui.TextComponent
import com.blessingmwiti.funfacts.ui.TextFieldComponent
import com.blessingmwiti.funfacts.ui.TopBar
import com.blessingmwiti.funfacts.ui.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)) {
            TopBar(value = "Hi there \uD83D\uDE0A")

            Spacer(modifier = Modifier.size(5.dp))

            TextComponent(
                textValue = "Let's learn about you !",
                testSize = 24.sp)

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "This app will prepare a details page based on info provided by you",
                testSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Name", testSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            } )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "What do you like?", testSize = 18.sp)

            Row (
                modifier = Modifier.fillMaxWidth()
                ) {
                AnimalCard(image = R.drawable.catto, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected=="Cat")
                AnimalCard(image = R.drawable.doggo, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected=="Dog"
                )
            }
            
            Spacer(modifier = Modifier.weight(1F))

            if(userInputViewModel.uiState.value.nameEntered.isNotEmpty()
                &&
                userInputViewModel.uiState.value.animalSelected.isNotEmpty()
            ){
                ButtonComponent (
                    gotToDetailsScreen = {
                        println("========ComingHere")
                        println("========${userInputViewModel.uiState.value.nameEntered} and ${userInputViewModel.uiState.value.animalSelected}")
                    }
                )
            }

        }

    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel())
}