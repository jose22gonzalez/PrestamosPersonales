package edu.ucne.prestamospersonales.util

sealed class screen(val route: String) {
    object ocupacionlistscreen: screen("OccupationListScreen")
    object ocupacionscreen: screen("OcupacionScreen")
}