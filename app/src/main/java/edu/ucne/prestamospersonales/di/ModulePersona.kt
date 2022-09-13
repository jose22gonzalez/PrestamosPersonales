package edu.ucne.prestamospersonales.di

import android.content.Context
import androidx.room.Room
import edu.ucne.prestamospersonales.data.personasDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModulePersona {
    @Singleton
    @Provides
    fun providesDataBase(@ApplicationContext context: Context): personasDatabase {
        return Room.databaseBuilder(
            context,
            personasDatabase::class.java,
            "SpellingDB"
        ).fallbackToDestructiveMigration().build()
    }

}