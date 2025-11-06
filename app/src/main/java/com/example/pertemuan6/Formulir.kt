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

@Composable
fun FormulirScreen(
    viewModel: FormulirViewModel,
    navController: NavController
) {
    // Ambil data (state) dari ViewModel
    val uiState by viewModel.uiState.collectAsState()

    val jenisKelaminOptions = listOf("Laki-laki", "Perempuan")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
                fontWeight = FontWeight.Bold
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
                value = uiState.nama,
                onValueChange = { viewModel.setNama(it) },
                label = { Text(stringResource(R.string.nama_lengkap)) },
                modifier = Modifier.fillMaxWidth()
            )

            // Input Jenis Kelamin
            Text(text = stringResource(R.string.jenis_kelamin))
            Row {
                jenisKelaminOptions.forEach { text ->
                    Row(
                        Modifier
                            .selectable(
                                selected = uiState.jenisKelamin == text,
                                onClick = { viewModel.setJenisKelamin(text) }
                            )
                            .padding(horizontal = dimensionResource(R.dimen.padding_small))
                    ) {
                        RadioButton(
                            selected = uiState.jenisKelamin == text,
                            onClick = { viewModel.setJenisKelamin(text) }
                        )
                        Text(text = text)
                    }
                }
            }

            // Input Alamat
            OutlinedTextField(
                value = uiState.alamat,
                onValueChange = { viewModel.setAlamat(it) },
                label = { Text(stringResource(R.string.alamat)) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))

            // Tombol Submit
            Button(
                onClick = {
                    // Perintah untuk pindah layar
                    navController.navigate("tabelData")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.submit))
            }
        }
    }
}