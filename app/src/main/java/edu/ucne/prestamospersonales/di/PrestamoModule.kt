package edu.ucne.prestamospersonales.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.prestamospersonales.data.PrestamoDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PrestamoModule {
    @Singleton
    @Provides
    fun providesDataBase(@ApplicationContext context: Context): PrestamoDataBase {
        return Room.databaseBuilder(
            context,
            PrestamoDataBase::class.java,
            "SpellingDB"
        ).fallbackToDestructiveMigration().build()
    }
}