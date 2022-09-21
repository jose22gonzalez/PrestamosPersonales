package edu.ucne.prestamospersonales.ui.Ocupaciones.OcupacionList


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.prestamospersonales.data.entity.occupacionentity
import edu.ucne.prestamospersonales.respository.ocupacionesrepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class OccupationListUIState(
    val occupations: List<occupacionentity> = emptyList(),

    )

@HiltViewModel
class OccupationListViewModel @Inject constructor(
    val respository: ocupacionesrepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(OccupationListUIState())
    val uiState: StateFlow<OccupationListUIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            respository.getAll().collect { list ->
                _uiState.update {
                    it.copy(occupations = list)
                }
            }
        }
    }

    fun DeleteOccupation(occupacionentity: occupacionentity) {
        viewModelScope.launch(Dispatchers.IO) {
            respository.deleteOccupation(occupacionentity)
        }
    }
}