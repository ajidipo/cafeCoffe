package com.example.cafecoffejc

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cafecoffejc.ui.theme.Purple40
import com.example.cafecoffejc.ui.theme.black


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textKomponen1(
    input:String,
    label:String,
    onValueChange :(String) -> Unit
){
        OutlinedTextField(
            value = input,
            onValueChange = onValueChange,
            label = { Text(label, color = black) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Purple40,
                unfocusedIndicatorColor = Color.White,
                textColor = black
            )
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textKomponen2(
    input:String,
    label:String,
    onValueChange :(String) -> Unit
){
        OutlinedTextField(
            value = input,
            onValueChange = onValueChange,
            label = { Text(label, color = black) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Purple40,
                unfocusedIndicatorColor = Color.White,
                textColor = black
            )
        )
}