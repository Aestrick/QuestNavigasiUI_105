package com.example.pertemuan6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan6.ui.theme.Pertemuan6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pertemuan6Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // --- INTI NAVIGASI & MVVM ---

                    // 1. Buat NavController (Remote TV)
                    val navController = rememberNavController()

                    // 2. Buat satu instance ViewModel
                    // Ini akan dibagikan ke kedua screen
                    val viewModel: `FormulirViewModel.kt` = viewModel()

                    // 3. Buat NavHost (TV-nya)
                    NavHost(
                        navController = navController,
                        startDestination = "formulir" // Layar pertama
                    ) {
                        // Layar "formulir"
                        composable("formulir") {
                            FormulirScreen(
                                viewModel = viewModel,
                                navController = navController
                            )
                        }

                        // Layar "tabelData"
                        composable("tabelData") {
                            TabelDataScreen(
                                viewModel = viewModel,
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}