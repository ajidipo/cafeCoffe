package com.example.cafecoffejc

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cafecoffejc.ui.theme.Red
import com.example.cafecoffejc.ui.theme.black

@Preview(showBackground = true)
@Composable
fun textLayout(){

    var nama by remember { mutableStateOf("") }
    var noMeja by remember { mutableStateOf("") }
    var hasil by remember { mutableStateOf("") }
    var hasil3 by remember { mutableStateOf("") }
    var hasil2 by remember { mutableStateOf("") }
    var kopi by remember { mutableStateOf(0) }
    var kopi1 by remember { mutableStateOf("") }
    var hasilTopping by remember { mutableStateOf("") }
    var harga by remember { mutableStateOf(5000) }
    var jumlahHarga by remember { mutableStateOf(0) }

    val options = listOf("Ice Cream", "Coklat", "Cream")
    val selectedOption = remember { mutableStateOf(options.first()) }


    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cafe Cofffe Dipz",
            color = black,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Row() {
            textKomponen1(
                input = nama,
                label = "Name",
                onValueChange = {
                    nama = it

                }
            )
            textKomponen2(
                input = noMeja,
                label = "No Meja",
                onValueChange = {
                    noMeja = it
                }
            )
        }
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        Row() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Jumlah",
                    color = black,
                    fontSize = 20.sp
                )
                Button(onClick = {
                    if (kopi < 5) kopi1 = "${++kopi}"
                }, colors = ButtonDefaults.buttonColors(Red)) {
                    Text(text = "+")
                }
                Text(
                    text = "$kopi1",
                    color = black,
                    fontSize = 15.sp
                )
                Button(onClick = {
                    if (kopi > 0) kopi1 = "${--kopi}"
                },
                    colors = ButtonDefaults.buttonColors(Red)) {
                    Text(text = "-")
                }
            }
            Spacer(modifier = Modifier.padding(horizontal = 40.dp))
            Column(
                Modifier
                    .padding(16.dp)
            ) {
                Text(
                    modifier = Modifier.align(CenterHorizontally), text = "Topping"
                )
                options.forEach{option ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selectedOption.value = option }
                            .padding(vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        RadioButton(selectedOption.value == option)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = option)
                    }
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    hasil = nama;hasil2 = noMeja;hasil3 = kopi1;jumlahHarga = harga * hasil3.toInt();hasilTopping =
                    selectedOption.toString()
                }) {
                Text(text = "Hitung"
                )
            }
            Text(
                text = "Nama: $hasil",
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Meja: $hasil2",
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Kopi: $hasil3",
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "jumlah harga: $jumlahHarga",
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Topping: $hasilTopping",
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}


@Composable
fun RadioButton(selected: Boolean) {
    val radioColor = if (selected) MaterialTheme.colorScheme.primary else Color.LightGray
    val radioSize = 20.dp

    Box(
        modifier = Modifier
            .size(radioSize)
            .background(color = radioColor, shape = CircleShape)
    ) {
        if (selected) {
            Box(
                modifier = Modifier
                    .size(radioSize - 8.dp)
                    .align(Alignment.Center),
                content = {}
            )
        }
    }
}