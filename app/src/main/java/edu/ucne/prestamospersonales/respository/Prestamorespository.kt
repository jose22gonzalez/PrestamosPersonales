package edu.ucne.prestamospersonales.respository

import edu.ucne.prestamospersonales.data.PrestamoDataBase
import edu.ucne.prestamospersonales.data.entity.PrestamoEntity
import javax.inject.Inject

class Prestamorespository @Inject constructor(
    val db: PrestamoDataBase
) {
    suspend fun InsertPrestamo(prestamoEntity: PrestamoEntity){
        db.prestamosDao.Insertar(prestamoEntity)
    }

    suspend fun ActualizarPrestamo(prestamoEntity: PrestamoEntity){
        db.prestamosDao.Actualizar(prestamoEntity)
    }

    suspend fun EliminarPrestamo(prestamoEntity: PrestamoEntity){
        db.prestamosDao.Eliminar(prestamoEntity)
    }

    fun getPrestamo(prestamosId: Int) = db.prestamosDao.FindPrestamo(prestamosId)

    fun getAll() = db.prestamosDao.getAll()
}