package edu.ucne.prestamospersonales.ui.Prestamos.PrestamosListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonales.data.entity.PrestamoEntity
import edu.ucne.prestamospersonales.respository.Prestamorespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PrestamoListUIState(
    val prestamos: List<PrestamoEntity> = emptyList()
)

@HiltViewModel
class PrestamosListViewModel @Inject constructor(
    val respository: Prestamorespository
) : ViewModel() {
    private  val _uiState = MutableStateFlow(PrestamoListUIState())
    val uiState: StateFlow<PrestamoListUIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            respository.getAll().collect{list ->
                _uiState.update {
                    it.copy(prestamos = list)
                }
            }
        }
    }

    fun EliminarPrestamo(prestamoEntity: PrestamoEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            respository.EliminarPrestamo(prestamoEntity)
        }
    }
}