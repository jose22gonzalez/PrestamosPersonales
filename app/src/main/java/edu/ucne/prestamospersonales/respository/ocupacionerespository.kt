package edu.ucne.prestamospersonales.respository

import edu.ucne.prestamospersonales.data.ocupacionDatabase
import edu.ucne.prestamospersonales.data.entity.occupacionentity
import javax.inject.Inject
import androidx.room.Room

class ocupacionesrepository @Inject constructor(
    val db: ocupacionDatabase
) {
    suspend fun insertOccupation(occupacionentity: occupacionentity) {
        db.ocupaciondao.insertar(occupacionentity)
    }

    suspend fun updateOccupation(occupacionentity: occupacionentity) {
        db.ocupaciondao.actualizar(occupacionentity)
    }

    suspend fun deleteOccupation(occupacionentity: occupacionentity) {
        db.ocupaciondao.eliminar(occupacionentity)
    }

    fun getOccupation(occupationId: Int) = db.ocupaciondao.getocupacione(occupationId)

    fun getAll() = db.ocupaciondao.getall()
}