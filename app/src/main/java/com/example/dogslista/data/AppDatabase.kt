package com.example.dogslist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dogslista.data.entities.DogEntity

@Database(entities = [DogEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dogDao(): DogDao
}
