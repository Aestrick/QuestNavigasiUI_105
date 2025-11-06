package com.example.pertemuan6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pertemuan6.ui.theme.Pertemuan6Theme // Pastikan nama tema-mu benar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pertemuan6Theme(darkTheme = false) {
                DataApp()
            }
        }
    }
}