package com.blessingmwiti.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blessingmwiti.funfacts.ui.TextComponent
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
                textValue = "This app will prepare a details page based on details provided by you",
                testSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))
        }

    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(userInputViewModel)
}