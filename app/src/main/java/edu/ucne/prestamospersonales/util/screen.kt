package edu.ucne.prestamospersonales.util

sealed class screen(val route: String) {
    object ocupacionlistscreen: screen("OccupationListScreen")
    object ocupacionscreen: screen("OcupacionScreen")
    object home: screen("HomeScreen")
    object personascreen: screen("PersonasScreen")
    object personalistscreen: screen("PersonaListScreen")
    object prestamolistscreen: screen("PrestamosListScreen")
    object prestamoscreen: screen("PrestamosScreen")
}