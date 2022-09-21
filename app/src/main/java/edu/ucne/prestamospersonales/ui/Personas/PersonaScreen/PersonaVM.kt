package edu.ucne.prestamospersonales.ui.Personas.PersonaScreen


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.prestamospersonales.data.entity.personasentity
import edu.ucne.prestamospersonales.respository.personasrespository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class personasviewmodel @Inject constructor(
    val respository: personasrespository
) : ViewModel() {
    var nombre by mutableStateOf("")
    var telefono by mutableStateOf("")
    var celular by mutableStateOf("")
    var email by mutableStateOf("")
    var direccion by mutableStateOf("")
    var fechanacimiento by mutableStateOf("")
    var ocupacion by mutableStateOf("")

    fun save() {
        viewModelScope.launch {
            respository.insertOccupation(
                personasentity(
                    nombre = nombre,
                    telefono = telefono,
                    celular = celular,
                    email = email,
                    direccion = direccion,
                    fechanacimiento = fechanacimiento,
                    ocupacion = ocupacion,
                    Balance = 0.0

                )
            )
        }
    }
}
