package edu.ucne.prestamospersonales.data.dao

import androidx.room.*
import edu.ucne.prestamospersonales.data.entity.occupacionentity
import kotlinx.coroutines.flow.Flow

@Dao
interface ocupaciondao {
    @Insert
    suspend fun insertar(occupacionentity: occupacionentity)

    @Update
    suspend fun actualizar(occupacionentity: occupacionentity)

    @Delete
    suspend fun eliminar(occupacionentity: occupacionentity)

    @Query("SELECT * FROM Ocupaciones WHERE occupacionid = :id")
    fun getocupacione(id:Int): Flow<occupacionentity>

    @Query("SELECT * from ocupaciones")
    fun getall(): Flow<List<occupacionentity>>
}