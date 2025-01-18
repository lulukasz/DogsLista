package com.example.dogslist.data

import androidx.room.*
import com.example.dogslista.data.entities.DogEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DogDao {
    @Query("SELECT * FROM dogs")
    fun getAllDogs(): Flow<List<DogEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDog(dog: DogEntity): Long

    @Update
    suspend fun updateDog(dog: DogEntity): Int
}
