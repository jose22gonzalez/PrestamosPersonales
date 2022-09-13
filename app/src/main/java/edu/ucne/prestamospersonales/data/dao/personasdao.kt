package edu.ucne.prestamospersonales.data.dao

import androidx.room.*
import edu.ucne.prestamospersonales.data.entity.personasentity
import kotlinx.coroutines.flow.Flow

@Dao
interface personadao {
    @Insert
    suspend fun insertar(personasentity: personasentity)

    @Update
    suspend fun actualizar(personasentity: personasentity)

    @Delete
    suspend fun eliminar(personasentity: personasentity)

    @Query("SELECT * FROM Personas WHERE personasid = :id")
    fun getpersonas(id:Int): Flow<personasentity>

    @Query("SELECT * from Personas")
    fun getall(): Flow<List<personasentity>>
}