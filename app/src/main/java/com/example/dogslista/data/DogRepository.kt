package com.example.dogslista.data

import com.example.dogslista.data.entities.DogEntity
import com.example.dogslista.data.entities.DogDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface DogRepository {
    val dogs: Flow<List<DogEntity>>

    suspend fun add(name: String)
    suspend fun remove(id: Int)
    suspend fun triggerFav(id: Int)
}

@Singleton
class DefaultDogRepository @Inject constructor(
    private val dogDao: DogDao
) : DogRepository {

    override val dogs: Flow<List<DogEntity>> = dogDao.getSortedDogs()

    override suspend fun add(name: String) {
        dogDao.insertDog(DogEntity(name = name, isFav = false))
    }

    override suspend fun remove(id: Int) {
        dogDao.removeDog(id)
    }

    override suspend fun triggerFav(id: Int) {
        dogDao.triggerFavDog(id)
    }
}
