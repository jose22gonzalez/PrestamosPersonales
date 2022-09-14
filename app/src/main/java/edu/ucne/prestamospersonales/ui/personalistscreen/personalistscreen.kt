package edu.ucne.prestamospersonales.ui.personalistscreen


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.IconButton
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.prestamospersonales.data.entity.personasentity
import java.util.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonasListScreen(
    onClick: () ->Unit,
    viewModel: PersonaListviewmodel = hiltViewModel()
) {
    Scaffold (
        topBar = {CenterAlignedTopAppBar(title = {Text("Personas List")})
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add a Occupation")
            }

        },

        ) {
        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)) {
            PersonaList(
                persona = uiState.personas,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )

        }
    }


}



@Composable
fun PersonaList(
    persona: List<personasentity>,
    viewModel: PersonaListviewmodel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(persona) { persona ->
            PersonaRow(persona, viewModel)
        }
    }
}

@Composable
fun PersonaRow(personasentity: personasentity, viewModel: PersonaListviewmodel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            text = "Nombre ${ personasentity.nombre }",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Email: ${personasentity.email}",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Celular: ${personasentity.celular}",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Telefono: ${personasentity.telefono}",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Direccion: ${personasentity.direccion}",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Fecha de Nacimiento: ${personasentity.fechanacimiento}",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Ocupacion: ${personasentity.ocupacion}",
            style = MaterialTheme.typography.titleLarge
        )



        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(
                modifier = Modifier.padding(0.dp),
                onClick = { viewModel.DeletePersona(personasentity)}) {
                Icon(imageVector = Icons.Outlined.Clear, contentDescription = "add",
                    tint = Color.Red)
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            color = Color.LightGray
        )
    }
}