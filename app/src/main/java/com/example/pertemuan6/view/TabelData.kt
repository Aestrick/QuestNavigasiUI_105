package com.example.pertemuan6.view

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
import com.example.pertemuan6.R

@Composable
fun TampilDataScreen(
    navController: NavController,
    nama: String?,
    jenisKelamin: String?,
    alamat: String?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = stringResource(R.string.tampil),
            fontSize = 20.sp,
            color = Color.Black
        )

        DataRow(
            label = stringResource(R.string.nama_lengkap),
            value = nama ?: ""
        )
        Divider(thickness = dimensionResource(R.dimen.thickness_divider), color = Color.Gray)

        DataRow(
            label = stringResource(R.string.jenis_kelamin),
            value = jenisKelamin ?: ""
        )
        Divider(thickness = dimensionResource(R.dimen.thickness_divider), color = Color.Gray)

        DataRow(
            label = stringResource(R.string.alamat),
            value = alamat ?: ""
        )
        Divider(thickness = dimensionResource(R.dimen.thickness_divider), color = Color.Gray)

        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text(text = stringResource(R.string.back))
        }
    }
}

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
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold
        )
    }
}