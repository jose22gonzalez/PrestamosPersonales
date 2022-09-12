package edu.ucne.prestamospersonales.data.entity

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Dao
@Entity(tableName = "Ocupaciones")
data class occupacionentity (
    @PrimaryKey(autoGenerate = true)
    val occupacionid: Int = 0,
    val descripcion: String = "",
    val salrio: Double
)