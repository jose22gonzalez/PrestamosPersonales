package edu.ucne.prestamospersonales.ui.Personas.PersonasListScreen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucne.prestamospersonales.data.entity.personasentity
import edu.ucne.prestamospersonales.respository.personasrespository
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.prestamospersonales.ui.Ocupaciones.OcupacionScreen.ocupacionviewmodel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class PersonaListUIState(
    val personas: List<personasentity> = emptyList(),

    )

@HiltViewModel
class PersonaListviewmodel @Inject constructor(
    val respository: personasrespository,

) : ViewModel() {

    private val _uiState = MutableStateFlow(PersonaListUIState())
    val uiState: StateFlow<PersonaListUIState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            respository.getAll().collect { list ->
                _uiState.update {
                    it.copy(personas = list)
                }
            }
        }
    }

    fun DeletePersona(personasentity: personasentity) {
        viewModelScope.launch(Dispatchers.IO) {
            respository.deleteOccupation(personasentity)
        }
    }
}