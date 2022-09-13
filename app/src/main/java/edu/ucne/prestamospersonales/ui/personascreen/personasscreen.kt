package edu.ucne.prestamospersonales.ui.personascreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import edu.ucne.prestamospersonales.ui.personascreen.personasviewmodel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonasScreen(
    onNavigateBack: () -> Unit,
    viewModel: personasviewmodel = hiltViewModel()
) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Personas Entry")})
        },

        ) {

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
//                .padding(it)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Nombre")},
                value = viewModel.nombre,
                onValueChange = {viewModel.nombre = it}
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Telefono")},
                value = viewModel.telefono,
                onValueChange = {viewModel.telefono = it},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = {Text(text = "Celular")},
                value = viewModel.celular,
                onValueChange = {viewModel.celular = it},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )

            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email")},
                value = viewModel.email,
                onValueChange = {viewModel.email = it}
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Direccion")},
                value = viewModel.direccion,
                onValueChange = {viewModel.direccion = it}
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Fecha Nacimiento")},
                value = viewModel.fechanacimiento,
                onValueChange = {viewModel.fechanacimiento = it}
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Ocupacion")},
                value = viewModel.ocupacion,
                onValueChange = {viewModel.ocupacion = it}
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ,

                onClick = {
                    viewModel.save()
                    onNavigateBack()
                }) {
                Text(text = "Add a Personas")
            }

        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    PersonasScreen( {  })
}