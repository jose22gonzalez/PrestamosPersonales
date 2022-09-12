package edu.ucne.prestamospersonales.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.ucne.prestamospersonales.data.dao.ocupaciondao
import edu.ucne.prestamospersonales.data.entity.occupacionentity

@Database(
    entities = [occupacionentity::class],
    version = 1,
    exportSchema = false
)
abstract class ocupacionDatabase: RoomDatabase(){

    abstract val ocupaciondao: ocupaciondao

    companion object {

        @Volatile
        private var INSTANCE: ocupacionDatabase? = null

        fun getInstance(context: Context): ocupacionDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ocupacionDatabase::class.java,
                        "Ocupaciones"
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
