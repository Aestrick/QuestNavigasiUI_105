package com.example.pertemuan6

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// Ini adalah ViewModel kita
class FormulirViewModel : ViewModel() {

    // _uiState adalah data internal yang 'mutable' (bisa diubah)
    private val _uiState = MutableStateFlow(DataFormulir())

    // uiState adalah data eksternal yang 'read-only'
    // View akan mengamati (observe) data ini
    val uiState: StateFlow<DataFormulir> = _uiState.asStateFlow()

    // Fungsi publik untuk mengubah nama
    fun setNama(nama: String) {
        _uiState.update { currentState ->
            currentState.copy(nama = nama)
        }
    }

    // Fungsi publik untuk mengubah alamat
    fun setAlamat(alamat: String) {
        _uiState.update { currentState ->
            currentState.copy(alamat = alamat)
        }
    }

    // Fungsi publik untuk mengubah jenis kelamin
    fun setJenisKelamin(jenisKelamin: String) {
        _uiState.update { currentState ->
            currentState.copy(jenisKelamin = jenisKelamin)
        }
    }
}