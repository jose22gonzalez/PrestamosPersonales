package edu.ucne.prestamospersonales.respository

import edu.ucne.prestamospersonales.data.personasDatabase
import edu.ucne.prestamospersonales.data.entity.personasentity
import javax.inject.Inject

class personasrespository @Inject constructor(
    val db: personasDatabase
) {
    suspend fun insertOccupation(personasentity: personasentity) {
        db.personadao.insertar(personasentity)
    }

    suspend fun updateOccupation(personasentity: personasentity) {
        db.personadao.actualizar(personasentity)
    }

    suspend fun deleteOccupation(personasentity: personasentity) {
        db.personadao.eliminar(personasentity)
    }

    fun getOccupation(personasid: Int) = db.personadao.getpersonas(personasid)

    fun getAll() = db.personadao.getall()
}