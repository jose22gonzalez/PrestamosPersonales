package edu.ucne.prestamospersonales.data.entity

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Dao
@Entity(tableName = "Prestamos")
data class PrestamoEntity(
    @PrimaryKey(autoGenerate = true)
    val PrestamoId: Int = 0,
    val Fecha: String,
    val FechaVencimiento: String,
    val Persona: String,
    val Concepto: String,
    val Monto: Double,
    val Balance: Double,

    )