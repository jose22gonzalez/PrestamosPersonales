package edu.ucne.prestamospersonales.data.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import edu.ucne.prestamospersonales.data.entity.PrestamoEntity

@Dao
interface PrestamosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(prestamoEntity: PrestamoEntity)

    @Update
    suspend fun Actualizar(prestamoEntity: PrestamoEntity)

    @Delete
    suspend fun Eliminar(prestamoEntity: PrestamoEntity)

    @Query("SELECT * FROM Prestamos WHERE PrestamoId = :id LIMIT 1")
     fun FindPrestamo(id:Int): Flow<PrestamoEntity>

    @Query("SELECT * FROM Prestamos")
    fun getAll(): Flow<List<PrestamoEntity>>
}