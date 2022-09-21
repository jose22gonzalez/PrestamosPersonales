package edu.ucne.prestamospersonales.data.entity

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Dao
@Entity(tableName = "Personas")
data class personasentity(
    @PrimaryKey(autoGenerate = true)
    val personasid: Int = 0,
    val nombre: String,
    val telefono: String,
    val celular: String,
    val email: String,
    val direccion: String,
    val fechanacimiento: String,
    val ocupacion: String,
    val Balance: Double

)