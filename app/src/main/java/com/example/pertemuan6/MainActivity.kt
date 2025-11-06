package com.example.pertemuan6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "formulir"
                    ) {
                        composable("formulir") {
                            FormulirScreen(navController = navController)
                        }

                        composable(
                            route = "tabelData/{nama}/{jenisKelamin}/{alamat}",
                            arguments = listOf(
                                navArgument("nama") { type = NavType.StringType },
                                navArgument("jenisKelamin") { type = NavType.StringType },
                                navArgument("alamat") { type = NavType.StringType }
                            )
                        ) { backStackEntry ->
                            val nama = backStackEntry.arguments?.getString("nama")
                            val jenisKelamin = backStackEntry.arguments?.getString("jenisKelamin")
                            val alamat = backStackEntry.arguments?.getString("alamat")

                            TabelDataScreen(
                                navController = navController,
                                nama = nama,
                                jenisKelamin = jenisKelamin,
                                alamat = alamat
                            )
                        }
                    }
                }
            }
        }
    }
}