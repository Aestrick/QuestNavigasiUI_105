package com.example.pertemuan6

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.layout.systemBarsPadding // <-- IMPORT BARU

@Composable
fun FormulirScreen(
    navController: NavController
) {
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf("") }

    val jenisKelaminOptions = listOf("Laki-laki", "Perempuan")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding() // <-- FIX #1: TAMBAHKAN INI
    ) {
        // Header Biru
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(dimensionResource(R.dimen.padding_medium)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.home),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        // Konten Formulir
        Column(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            // Input Nama
            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it },
                label = { Text(stringResource(R.string.nama_lengkap)) },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedLabelColor = Color.DarkGray,
                    unfocusedLabelColor = Color.DarkGray
                )
            )

            // Input Jenis Kelamin
            Text(
                text = stringResource(R.string.jenis_kelamin),
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
            Row {
                jenisKelaminOptions.forEach { text ->
                    Row(
                        Modifier
                            .selectable(
                                selected = jenisKelamin == text,
                                onClick = { jenisKelamin = text }
                            )
                            .padding(horizontal = dimensionResource(R.dimen.padding_small)),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = jenisKelamin == text,
                            onClick = { jenisKelamin = text }
                        )
                        Text(text = text, color = Color.DarkGray)
                    }
                }
            }

            // Input Alamat
            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = { Text(stringResource(R.string.alamat)) },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedLabelColor = Color.DarkGray,
                    unfocusedLabelColor = Color.DarkGray
                )
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

            // Tombol Submit
            Button(
                onClick = {
                    navController.navigate("tabelData/$nama/$jenisKelamin/$alamat")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.submit))
            }
        }
    }
}