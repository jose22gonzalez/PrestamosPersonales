package edu.ucne.prestamospersonales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.Modifier
import edu.ucne.prestamospersonales.ui.theme.PrestamosPersonalesTheme
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.Provides
import edu.ucne.prestamospersonales.ui.ocupacionlist.OccupationListScreen
import edu.ucne.prestamospersonales.ui.ocupacionscreen.OcupacionScreen
import edu.ucne.prestamospersonales.util.screen
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.prestamospersonales.ui.home.HomeScreen
import edu.ucne.prestamospersonales.ui.personascreen.PersonasScreen
import edu.ucne.prestamospersonales.ui.personalistscreen.PersonasListScreen

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
                        startDestination = screen.home.route
                    ) {
                        composable(screen.home.route){
                            HomeScreen(
                                onClick = {navController.navigate(screen.ocupacionlistscreen.route)},
                                onClickPerson = {navController.navigate(screen.personalistscreen.route)}
                            )
                        }
                        composable(screen.ocupacionlistscreen.route) {
                            OccupationListScreen({ navController.navigateUp() })
                        }
                        composable(screen.ocupacionlistscreen.route) {
                            OccupationListScreen(
                                onClick = {navController.navigate(screen.ocupacionscreen.route)}
                            )
                        }
                        composable(screen.ocupacionscreen.route){
                            OcupacionScreen({ navController.navigateUp()})
                        }

                       composable(screen.personalistscreen.route) {
                           PersonasListScreen(
                               onClick = { navController.navigate(screen.personascreen.route) }
                           )
                       }

                        composable(screen.personascreen.route){
                            PersonasScreen({navController.navigateUp()})
                        }

                    }

                    
                }
            }
        }
    }
}

