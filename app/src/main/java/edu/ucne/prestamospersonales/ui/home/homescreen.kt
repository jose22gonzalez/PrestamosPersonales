package edu.ucne.prestamospersonales.ui.home


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.twotone.AccountBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClick: () -> Unit,
    onClickPerson: () -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    TopAppBar(
        title = { Text(text = "Prestamos Personales") },
        navigationIcon = {
            Icon(imageVector = Icons.Rounded.Menu, contentDescription =null )

                         },
        actions = {

            IconButton(onClick = onClick) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add a Occupation")
            }
            IconButton(onClick = onClickPerson) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Add a Persona")
            }
        }
    )
}



