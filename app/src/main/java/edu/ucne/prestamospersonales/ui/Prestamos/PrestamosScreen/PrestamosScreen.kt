package edu.ucne.prestamospersonales.ui.Prestamos.PrestamosScreen


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import edu.ucne.prestamospersonales.data.entity.occupacionentity
import edu.ucne.prestamospersonales.data.entity.personasentity
import edu.ucne.prestamospersonales.ui.Prestamos.PrestamosScreen.PrestamosViewModel
import java.util.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrestamoScreen(
    onNavigateBack: () -> Unit,
    viewModel: PrestamosViewModel = hiltViewModel()
) {

    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)

    val contextDate = LocalContext.current

    var dateFecha  by remember {
        mutableStateOf("")
    }
    val datePickerDialog = DatePickerDialog(
        contextDate, { d, year1, month1, day1 ->
            val month = month1 + 1
            dateFecha = "$day1 - $month1 - $year1"
        }, year, month, day
    )

    val cV = Calendar.getInstance()
    val yearV = cV.get(Calendar.YEAR)
    val monthV = cV.get(Calendar.MONTH)
    val dayV = cV.get(Calendar.DAY_OF_MONTH)

    val contextDateV = LocalContext.current

    var dateFechaV  by remember {
        mutableStateOf("")
    }
    val datePickerDialogV = DatePickerDialog(
        contextDateV, { d, year1, month1, day1 ->
            val month = month1 + 1
            dateFechaV = "$day1 - $month1 - $year1"
        }, yearV, monthV, dayV
    )

    var PersonaSelect by remember {
        mutableStateOf("")
    }

    var expanded2 by remember {
        mutableStateOf(false)
    }

    val Personaslist = listOf(
        personasentity(personasid = 1, nombre = "Carmen", telefono = "555", celular = "555", email = "d@.com",
        direccion = "C/5",fechanacimiento = "5-8-1995", ocupacion = "Ingeniero", Balance = 0.0
            ),
        personasentity(personasid = 2, nombre = "Jose", telefono = "555",celular = "555",email = "d@.com",
            direccion = "C/5",fechanacimiento = "5-8-1995", ocupacion = "Ingeniero", Balance = 0.0
            ),
        personasentity(personasid = 3, nombre = "Lucia", telefono = "555",celular = "555",email = "d@.com",
            direccion = "C/5",fechanacimiento = "5-8-1995", ocupacion = "Ingeniero", Balance = 0.0
            ),
        personasentity(personasid = 4, nombre = "Antonio", telefono = "555",celular = "555",email = "d@.com",
            direccion = "C/5",fechanacimiento = "5-8-1995", ocupacion = "Ingeniero", Balance = 0.0
            ),
        personasentity(personasid = 5, nombre = "Maria", telefono = "555",celular = "555",email = "d@.com",
            direccion = "C/5", fechanacimiento = "5-8-1995", ocupacion = "Ingeniero", Balance = 0.0
            )
    )


    var context = LocalContext.current

    fun validarFechas(){
      if(dateFecha.compareTo(dateFechaV) >= 0){
          Toast.makeText(
              context,
              "Error, La Fecha de vencimiento debe ser mayor que Fecha",
              Toast.LENGTH_SHORT
          ).show()
      }else{
          if(viewModel.Fecha.isBlank() || viewModel.FechaVencimiento.isBlank() || viewModel.Persona.isBlank() || viewModel.Concepto.isBlank() || viewModel.Monto.isBlank() || viewModel.Balance.isBlank()){
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
    }

    Scaffold (

        topBar = {
            CenterAlignedTopAppBar(title = { Text("Prestamos  Entry")})
        },

    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .clickable { datePickerDialog.show() }               ,
                label = { Text(text = "Fecha")},
                value = viewModel.Fecha,
                onValueChange = {viewModel.Fecha = it},
                trailingIcon = { IconButton(onClick = {datePickerDialog.show()}) {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = "Fecha")
                }},
                readOnly = true,
            )

            viewModel.Fecha = dateFecha

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .clickable { datePickerDialogV.show() }               ,
                label = { Text(text = "Fecha Vencimiento")},
                value = viewModel.FechaVencimiento,
                onValueChange = {viewModel.FechaVencimiento = it},
                trailingIcon = { IconButton(onClick = {datePickerDialogV.show()}) {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = "Fecha Vencimiento")
                }},
                readOnly = true,
            )

            viewModel.FechaVencimiento = dateFechaV


            OutlinedTextField(
                value = viewModel.Persona,
                label = { Text(text = "Persona")},
                onValueChange = {viewModel.Persona = it},
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded2 = true }
                    .fillMaxWidth()
                    .padding(5.dp),
                trailingIcon = { IconButton(onClick = {expanded2 = true}) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Persona")

                }}

            )

            androidx.compose.material.DropdownMenu(
                expanded = expanded2,
                onDismissRequest = { expanded2 = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                Personaslist.forEach{persona ->
                    androidx.compose.material.DropdownMenuItem(onClick = {
                        expanded2 = false
                       PersonaSelect = persona.nombre
                    }) {
                        Text(text = persona.nombre)
                    }
                }
            }

            viewModel.Persona = PersonaSelect

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                label = { Text(text = "Concepto")},
                value = viewModel.Concepto,
                onValueChange = {viewModel.Concepto = it}
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                label = { Text(text = "Monto")},
                value = viewModel.Monto,
                onValueChange = {viewModel.Monto = it},

            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                label = { Text(text = "Balance")},
                value = viewModel.Balance,
                onValueChange = { viewModel.Balance = it },

                )


            Row(modifier = Modifier
//                .fillMaxWidth()
                .padding(it)
                .padding(5.dp),
                verticalAlignment = Alignment.CenterVertically
            )


            {
                Button(
                    modifier = Modifier
                        .padding(2.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    onClick = {
                    }) {
                    Text(
                        text = "Editar" ,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    modifier = Modifier
                        .padding(2.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(Color.Green),
                    onClick = {
                        validarFechas()
//                        viewModel.save()
//                        onNavigateBack()
                    }) {
                    Text(
                        text = "Guardar",
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    )
                }
                Button(
                    modifier = Modifier
                        .padding(2.dp)
                    ,
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    onClick = {

                    }) {
                    Text(
                        text = "Eliminar",
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    )
                }
            }

        }
    }
}
@Composable
fun Validar(FechaView: String, FechavView: String,PersonaView: String, ConceptoView: String, MontoView: String, BalanceView: String ) {
    var contextp = LocalContext.current

    if(FechaView.isBlank() || FechavView.isBlank() || PersonaView.isBlank() || ConceptoView.isBlank() || MontoView.isBlank() || BalanceView.isBlank()){
        Toast.makeText(
            contextp,
            "Error, No puede dejar las casillas vacia",
            Toast.LENGTH_SHORT
        ).show()

    }
}


@Composable
fun AlertDialog(){

    val context = LocalContext.current
    val openDialog = remember {
        mutableStateOf(true)
    }

    if(openDialog.value){
        androidx.compose.material.AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "Error", color = Color.Black)},
            text = {Text(text = "Error, no puede dejar la casilla vacia...", color = Color.Black)},
            confirmButton = {
                TextButton(onClick = {
                    openDialog.value = false
                    Toast.makeText(context, "Confirm Button Click", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Confirm", color = Color.Black)
                }
            },

            dismissButton = {
                TextButton(onClick = {
                    openDialog.value = false
                    Toast.makeText(context, "Dismiss Buttom Click", Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "Dismiss", color = Color.Black)
                }
            },
            backgroundColor = Color.White,
            contentColor = Color.White
        )

    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    PrestamoScreen( {  })
}