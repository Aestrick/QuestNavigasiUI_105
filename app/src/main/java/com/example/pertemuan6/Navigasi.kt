package com.example.pertemuan6

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pertemuan6.view.FormulirScreen
import com.example.pertemuan6.view.TampilDataScreen // <-- Pastikan import-nya TampilDataScreen

// Enum untuk rute, persis seperti di screenshot
enum class Navigasi {
    Formulirku,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulirku.name // Layar pertama
        ) {

            // Rute 1: Layar Formulir
            composable(route = Navigasi.Formulirku.name) {
                FormulirScreen(navController = navController)
            }

            // Rute 2: Layar Detail (TampilData)
            composable(
                route = "${Navigasi.Detail.name}/{nama}/{jenisKelamin}/{alamat}",
                arguments = listOf(
                    navArgument("nama") { type = NavType.StringType },
                    navArgument("jenisKelamin") { type = NavType.StringType },
                    navArgument("alamat") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                // Ambil data yang dikirim dari rute
                val nama = backStackEntry.arguments?.getString("nama")
                val jenisKelamin = backStackEntry.arguments?.getString("jenisKelamin")
                val alamat = backStackEntry.arguments?.getString("alamat")

                // --- PASTIIN NAMANYA SAMA ---
                // Panggil TampilDataScreen
                TampilDataScreen(
                    navController = navController,
                    nama = nama,
                    jenisKelamin = jenisKelamin,
                    alamat = alamat
                )
            }
        }
    }
}