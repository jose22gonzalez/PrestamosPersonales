package edu.ucne.prestamospersonales.ui.ocupacionscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.prestamospersonales.data.entity.occupacionentity
import edu.ucne.prestamospersonales.respository.ocupacionesrepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ocupacionviewmodel @Inject constructor(
    val respository: ocupacionesrepository
) : ViewModel() {
    var descripcion by mutableStateOf("")
    var salario by mutableStateOf("")


    fun validar(): Boolean{
        var paso = false
        if(descripcion.isBlank()){
            paso = true
        }else{
            if(salario.isBlank()){
                paso = true
            }
        }
        return paso
    }

    fun save() {
        viewModelScope.launch {
            respository.insertOccupation(
                occupacionentity(
                    descripcion = descripcion,
                    salrio = salario.toDouble()
                )
            )
        }

    }
}