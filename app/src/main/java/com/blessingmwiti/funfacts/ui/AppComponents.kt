package com.blessingmwiti.funfacts.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blessingmwiti.funfacts.R

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

@Composable
fun TextFieldComponent() {
    var currentValue by remember { mutableStateOf("") }

    OutlinedTextField(value = currentValue , onValueChange = {},
        placeholder = { Text(text = "Enter your name") })
}

@Preview (showBackground = true)
@Composable
fun TextFieldComponentPreview() {
    TextFieldComponent()
}