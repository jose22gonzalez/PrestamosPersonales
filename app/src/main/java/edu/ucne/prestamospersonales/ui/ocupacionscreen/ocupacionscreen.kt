package edu.ucne.prestamospersonales.ui.ocupacionscreen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcupacionScreen(
    onNavigateBack: () -> Unit,
    viewModel: ocupacionviewmodel = hiltViewModel()
) {


    var context = LocalContext.current
    fun ValidarTextFiel() {
        if (viewModel.descripcion.isBlank() || viewModel.salario.isBlank()){
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
            CenterAlignedTopAppBar(title = { Text("Occupation Entry")})
        },
        ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                label = { Text(text = "Descrition")},
                value = viewModel.descripcion,
                onValueChange = {viewModel.descripcion = it}
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
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
                    ValidarTextFiel()
//                    viewModel.save()
//                    onNavigateBack()
                }) {
                Text(text = "Add a Occupation")
            }

        }
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
    OcupacionScreen( {  })
}
