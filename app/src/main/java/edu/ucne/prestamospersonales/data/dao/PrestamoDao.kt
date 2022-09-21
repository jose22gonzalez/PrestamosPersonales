package edu.ucne.prestamospersonales.data.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import edu.ucne.prestamospersonales.data.entity.PersonaEntity

@Dao
interface PrestamosDao {
    @Insert
    suspend fun Insertar(personaEntity: PersonaEntity)

    @Update
    suspend fun Actualizar(personaEntity: PersonaEntity)

    @Delete
    suspend fun Eliminar(personaEntity: PersonaEntity)
}