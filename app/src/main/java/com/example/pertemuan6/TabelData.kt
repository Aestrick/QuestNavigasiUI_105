package com.example.pertemuan6

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun TabelDataScreen(
    navController: NavController,
    // --- KITA TERIMA DATA DARI NAVIGASI ---
    nama: String?,
    jenisKelamin: String?,
    alamat: String?
    // -------------------------------------
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = stringResource(R.string.tampil),
            fontSize = 20.sp,
            color = Color.Black
        )

        // Tampilkan Data
        DataRow(
            label = stringResource(R.string.nama_lengkap),
            value = nama ?: "" // Tampilkan data dari parameter
        )
        Divider(thickness = dimensionResource(R.dimen.thickness_divider))

        DataRow(
            label = stringResource(R.string.jenis_kelamin),
            value = jenisKelamin ?: "" // Tampilkan data dari parameter
        )
        Divider(thickness = dimensionResource(R.dimen.thickness_divider))

        DataRow(
            label = stringResource(R.string.alamat),
            value = alamat ?: "" // Tampilkan data dari parameter
        )
        Divider(thickness = dimensionResource(R.dimen.thickness_divider))

        // Tombol Kembali
        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text(text = stringResource(R.string.back))
        }
    }
}

// Fungsi bantuan biar rapi dan teksnya tebal
@Composable
fun DataRow(label: String, value: String) {
    Row(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = "$label: ",
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = value,
            color = Color.DarkGray
        )
    }
}