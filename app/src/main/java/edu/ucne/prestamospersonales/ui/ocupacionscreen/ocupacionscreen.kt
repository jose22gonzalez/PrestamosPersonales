package edu.ucne.prestamospersonales.ui.ocupacionscreen

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcupacionScreen(
    onNavigateBack: () -> Unit,
    viewModel: ocupacionviewmodel = hiltViewModel()
) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Occupation Entry")})

        },

        ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(8.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Descrition")},
                value = viewModel.descripcion,
                onValueChange = {viewModel.descripcion = it}
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Salary")},
                value = viewModel.salario,
                onValueChange = {viewModel.salario = it},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )


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
                Text(text = "Add a Occupation")
            }

        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    OcupacionScreen( {  })
}
