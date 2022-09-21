package edu.ucne.prestamospersonales.ui.Prestamos.PrestamosListScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.*
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import edu.ucne.prestamospersonales.data.entity.PrestamoEntity
import edu.ucne.prestamospersonales.data.entity.personasentity

@Composable
fun PrestamoListScreen(
    onClick: () ->Unit,
    viewModel: PrestamosListViewModel = hiltViewModel()
){
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text(text = "Prestamos List")})},
        floatingActionButton = {
            FloatingActionButton(onClick = onClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar prestamos")
            }
        }
    ) {
        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(it)
        ) {
            PrestamoList(
                prestamo = uiState.prestamos,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }

    }
}

@Composable
fun PrestamoList(
    prestamo: List<PrestamoEntity>,
    viewModel: PrestamosListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier) {
        items(prestamo) {prestamo ->
            PrestamoRow(prestamo, viewModel )
        }
    }
}

@Composable
fun PrestamoRow(
    prestamoEntity: PrestamoEntity,
    viewModel: PrestamosListViewModel
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)
    ) {
        Text(
            modifier = Modifier.padding(5.dp),
            text = "Persona: ${prestamoEntity.Persona}",
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center
        )


            Text(
                modifier = Modifier.padding(5.dp),
                text = "Fecha: ${prestamoEntity.Fecha}",
                style = MaterialTheme.typography.subtitle1
            )

            Text(
                modifier = Modifier.padding(5.dp),
                text = "Vencimiento: ${prestamoEntity.FechaVencimiento}",
                style = MaterialTheme.typography.subtitle1
            )

        Text(
            modifier = Modifier.padding(5.dp),
            text = "Concepto: ${prestamoEntity.Concepto}",
            style = MaterialTheme.typography.subtitle1
        )



            Text(
                modifier = Modifier.padding(5.dp),
                text = "Monto: ${prestamoEntity.Monto}",
                style = MaterialTheme.typography.subtitle1
            )

            Text(
                modifier = Modifier.padding(5.dp),
                text = "Balance: ${prestamoEntity.Balance}",
                style = MaterialTheme.typography.subtitle1
            )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {

            IconButton(
                modifier = Modifier.padding(3.dp),
                onClick = { viewModel.EliminarPrestamo(prestamoEntity)}) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Outlined.Clear, contentDescription = "add",
                    tint = Color.Red
                )
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