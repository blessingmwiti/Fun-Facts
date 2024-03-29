package com.blessingmwiti.funfacts.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blessingmwiti.funfacts.R
import com.blessingmwiti.funfacts.data.UserDataUiEvents

@Composable
fun TopBar (value: String) {
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text = value,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
            )
        Spacer(modifier = Modifier.weight(1f))
        Image(painter = painterResource(id = R.drawable.logo),
            modifier = Modifier.size(30.dp), contentDescription = "Fun Facts Logo")
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar(value = "Hi there \uD83D\uDE0A")
}

@Composable
fun TextComponent(textValue: String,
                  testSize: TextUnit,
                  colorValue: Color = Color.Black){
    Text(text = textValue,
        fontSize = testSize,
        color = colorValue,
        fontWeight = FontWeight.Light)
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(textValue = "Blessing Mwiti",
        testSize = 24.sp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    onTextChanged : (name:String) -> Unit
) {
    val localFocusManager = LocalFocusManager.current
    var currentValue by remember { mutableStateOf("") }
    OutlinedTextField(
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions{
                                         localFocusManager.clearFocus()
        },
        modifier = Modifier.fillMaxWidth(),
        value = currentValue , onValueChange = {
            currentValue = it
            onTextChanged(it)
        },
        placeholder = { Text(text = "Enter your name", fontSize = 18.sp) },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp)
    )
}

@Composable
fun AnimalCard(
    image:Int,
    selected: Boolean,
    animalSelected: (animalName:String) -> Unit
) {

    val localFocusManager = LocalFocusManager.current
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box (
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Animal image",
                modifier = Modifier
                    .padding(
                        horizontal = 25.dp,
                        vertical = 25.dp
                    )
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clickable {
                        val animalName = if (image == R.drawable.catto) "Cat" else "Dog"
                        animalSelected(animalName)
                        localFocusManager.clearFocus()
                    }
            )
        }

    }
}

//@Preview
//@Composable
//fun AnimalCardPreview() {
//    AnimalCard(R.drawable.doggo, false)
//}

@Composable
fun ButtonComponent(
    gotToDetailsScreen : () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = { gotToDetailsScreen() }
    ) {
        TextComponent(
            textValue = "Go to Details Screen",
            testSize = 18.sp,
            colorValue = Color.White
        )
    }
}