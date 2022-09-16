package edu.ucne.prestamospersonales.ui.home


import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.twotone.AccountBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.layout.height as height1
import androidx.compose.ui.unit.dp as dp1


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onClick: () -> Unit,
    onClickPerson: () -> Unit
) {

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Prestamos Personales") },
            navigationIcon = {
                Icon(imageVector = Icons.Rounded.Person, contentDescription =null )
            },
        )
    }) {
        Column(modifier = Modifier
            .padding(it)
            .padding(5.dp1),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bienvenido a Prestamos Personales",
                modifier = Modifier
                    .padding(5.dp1)
                ,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Registro Ocupacion",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp1),
                textAlign = TextAlign.Center
            )
            Button(onClick =  onClick , modifier = Modifier.padding(2.dp1)) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "Add a Occupation")
            }
            Text(
                text = "Registro Persona",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp1),
                textAlign = TextAlign.Center
            )
            Button(onClick =  onClickPerson , modifier = Modifier) {
                Icon(imageVector = Icons.Outlined.Person, contentDescription = "Add a Occupation")
            }
            
            Box(modifier = Modifier
//                .height1(200.dp1)
                .fillMaxWidth()
                .padding(5.dp1),
                contentAlignment = Alignment.Center

            ){
                Image(
                    painter = rememberAsyncImagePainter("https://images.unsplash.com/photo-1593672715438-d88a70629abe?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"),
                    contentDescription = null,
                    alignment = Alignment.Center,
                    modifier = Modifier.height1(400.dp1).width(600.dp1)
                )
            }
        }
    }

    }



