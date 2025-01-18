package com.example.dogslista.data.di

import android.content.Context
import androidx.room.Room
import com.example.dogslist.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "dogslista_database"
        ).build()
    }

    @Provides
    fun provideDogDao(database: AppDatabase): com.example.dogslist.data.DogDao {
        return database.dogDao()
    }
}
