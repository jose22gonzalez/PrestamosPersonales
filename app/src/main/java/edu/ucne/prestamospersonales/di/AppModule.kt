package edu.ucne.prestamospersonales.di

import android.content.Context
import androidx.room.Room
import edu.ucne.prestamospersonales.data.ocupacionDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesDataBase(@ApplicationContext context: Context): ocupacionDatabase {
        return Room.databaseBuilder(
            context,
            ocupacionDatabase::class.java,
            "SpellingDB"
        ).fallbackToDestructiveMigration().build()
    }
}