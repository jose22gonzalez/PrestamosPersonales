package edu.ucne.prestamospersonales.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ucne.prestamospersonales.data.dao.personadao
import edu.ucne.prestamospersonales.data.entity.personasentity

@Database(
    entities = [personasentity::class],
    version = 2,
    exportSchema = false
)
abstract class personasDatabase: RoomDatabase(){
    abstract val personadao: personadao
    companion object {
        @Volatile
        private var INSTANCE: personasDatabase? = null
        fun getInstance(context: Context): personasDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        personasDatabase::class.java,
                        "Personas"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
