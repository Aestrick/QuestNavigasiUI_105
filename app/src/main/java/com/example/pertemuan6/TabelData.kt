package com.example.pertemuan6

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController

@Composable
fun TabelDataScreen(
    viewModel: FormulirViewModel,
    navController: NavController
) {
    // Ambil data (state) dari ViewModel yang SAMA
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(text = stringResource(R.string.tampil))

        // Tampilkan Data
        Text(text = "${stringResource(R.string.nama_lengkap)}: ${uiState.nama}")
        Divider(thickness = dimensionResource(R.dimen.thickness_divider))

        Text(text = "${stringResource(R.string.jenis_kelamin)}: ${uiState.jenisKelamin}")
        Divider(thickness = dimensionResource(R.dimen.thickness_divider))

        Text(text = "${stringResource(R.string.alamat)}: ${uiState.alamat}")
        Divider(thickness = dimensionResource(R.dimen.thickness_divider))

        // Tombol Kembali
        Button(
            onClick = {
                // Perintah untuk kembali ke layar sebelumnya
                navController.popBackStack()
            }
        ) {
            Text(text = stringResource(R.string.back))
        }
    }
}