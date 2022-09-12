package edu.ucne.prestamospersonales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import edu.ucne.prestamospersonales.ui.theme.PrestamosPersonalesTheme
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.prestamospersonales.ui.ocupacionlist.OccupationListScreen
import edu.ucne.prestamospersonales.ui.ocupacionscreen.OcupacionScreen
import edu.ucne.prestamospersonales.util.screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrestamosPersonalesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = screen.ocupacionlistscreen.route
                    ) {
                        composable(screen.ocupacionlistscreen.route) {
                            OccupationListScreen(
                                onClick = {navController.navigate(screen.ocupacionscreen.route)}
                            )
                        }
                        composable(screen.ocupacionscreen.route){
                            OcupacionScreen({ navController.navigateUp()})
                        }

                    }
                }
            }
        }
    }
}

