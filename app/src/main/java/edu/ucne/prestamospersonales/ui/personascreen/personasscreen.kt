package edu.ucne.prestamospersonales.ui.personascreen

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.prestamospersonales.data.entity.occupacionentity
import edu.ucne.prestamospersonales.ui.ocupacionscreen.OcupacionScreen
import java.time.format.TextStyle
import java.util.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun PersonasScreen(
    onNavigateBack: () -> Unit,
    viewModel: personasviewmodel = hiltViewModel()
) {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    val context = LocalContext.current

    var date  by remember {
        mutableStateOf("")
    }
    val datePickerDialog = DatePickerDialog(
        context, { d, year1, month1, day1 ->
            val month = month1 + 1
            date = "$day1 - $month1 - $year1"
        }, year, month, day
    )

    var OccupatioSelect by remember {
        mutableStateOf("")
    }

    var expanded2 by remember {
        mutableStateOf(false)
    }

    val ocupacioneslist = listOf(
        occupacionentity(occupacionid = 1, descripcion = "Ingeniero", salrio = 100000.0),
        occupacionentity(occupacionid = 2, descripcion = "Doctor", salrio = 60000.0),
        occupacionentity(occupacionid = 3, descripcion = "Linceciado", salrio = 400000.0),
        occupacionentity(occupacionid = 4, descripcion = "Maestro", salrio = 30000.0),
        occupacionentity(occupacionid = 5, descripcion = "Director", salrio = 38000.0)
    )

    var contextp = LocalContext.current

    fun ValidarPerson() {
        if(viewModel.nombre.isBlank() || viewModel.telefono.isBlank() || viewModel.celular.isBlank()
            || viewModel.email.isBlank() || viewModel.direccion.isBlank() ||
            viewModel.fechanacimiento.isBlank() || viewModel.ocupacion.isBlank()
        ){
            Toast.makeText(
                context,
                "Error, No puede dejar las casillas vacia",
                Toast.LENGTH_SHORT
            ).show()
        }else{
            viewModel.save()
            onNavigateBack()
        }
    }


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
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                label = { Text(text = "Nombre")},
                value = viewModel.nombre,
                onValueChange = {viewModel.nombre = it},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "date")
                },
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                label = { Text(text = "Telefono")},
                value = viewModel.telefono,
                onValueChange = {viewModel.telefono = it},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Call, contentDescription = "date")
                },

            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                label = {Text(text = "Celular")},
                value = viewModel.celular,
                onValueChange = {viewModel.celular = it},
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Phone, contentDescription = "date")
                },

            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                label = { Text(text = "Email")},
                value = viewModel.email,
                onValueChange = {viewModel.email = it},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "date")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                )
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                label = { Text(text = "Direccion")},
                value = viewModel.direccion,
                onValueChange = {viewModel.direccion = it},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription = "date")
                },
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .clickable { datePickerDialog.show() }               ,
                label = { Text(text = "Fecha Nacimiento")},
                value = viewModel.fechanacimiento,
                onValueChange = {viewModel.fechanacimiento = it},
                trailingIcon = { IconButton(onClick = {datePickerDialog.show()}) {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = "date")
                }},
                readOnly = true,
            )

            viewModel.fechanacimiento = date

                OutlinedTextField(
                   value = viewModel.ocupacion,
                    label = { Text(text = "Ocupacion")},
                    onValueChange = {viewModel.ocupacion = it},
                    enabled = false,
                    readOnly = true,
                    modifier = Modifier
                        .clickable { expanded2 = true }
                        .fillMaxWidth().padding(5.dp),
                    trailingIcon = { IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "date")

                }}

                )

                androidx.compose.material.DropdownMenu(
                    expanded = expanded2,
                    onDismissRequest = { expanded2 = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ocupacioneslist.forEach{ocupacion ->
                    androidx.compose.material.DropdownMenuItem(onClick = {
                        expanded2 = false
                        OccupatioSelect = ocupacion.descripcion
                    }) {
                        Text(text = ocupacion.descripcion)
                    }
                }
                }

            viewModel.ocupacion = OccupatioSelect

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                ,

                onClick = {
                    ValidarPerson()
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