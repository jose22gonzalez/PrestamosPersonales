package edu.ucne.prestamospersonales.ui.Prestamos.PrestamosScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.prestamospersonales.data.entity.PrestamoEntity
import edu.ucne.prestamospersonales.respository.Prestamorespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrestamosViewModel @Inject constructor(
    val respository: Prestamorespository
) : ViewModel() {
    var Fecha by mutableStateOf("")
    var FechaVencimiento by mutableStateOf("")
    var Persona by mutableStateOf("")
    var Concepto by mutableStateOf("")
    var Monto by mutableStateOf("")
    var Balance by mutableStateOf("")

    fun save() {
        viewModelScope.launch {
            respository.InsertPrestamo(
                PrestamoEntity(
                    Fecha = Fecha,
                    FechaVencimiento = FechaVencimiento,
                    Persona = Persona,
                    Concepto = Concepto,
                    Monto = Monto.toDouble(),
                    Balance = Balance.toDouble()
                )
            )
        }

    }

    fun Editar(prestamoEntity: PrestamoEntity){

    }
}