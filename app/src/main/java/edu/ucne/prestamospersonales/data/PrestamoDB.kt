package edu.ucne.prestamospersonales.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ucne.prestamospersonales.data.dao.PrestamosDao
import edu.ucne.prestamospersonales.data.entity.PrestamoEntity

@Database(
    entities = [PrestamoEntity::class],
    version = 3,
    exportSchema = false
)
abstract class PrestamoDataBase : RoomDatabase() {
    abstract val prestamosDao: PrestamosDao
    companion object {
        @Volatile
        private var INSTACE: PrestamoDataBase? = null
        fun getInstance(context: Context) : PrestamoDataBase {
            synchronized(this) {
                var instance = INSTACE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PrestamoDataBase::class.java,
                        "Prestamos"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTACE = instance
                }

                return instance
            }
        }
    }
}