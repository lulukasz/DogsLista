package com.example.dogslista.data

import retrofit2.http.GET

interface RemoteDogService {
    @GET("breeds/image/random")
    suspend fun getRandomDogImage(): RemoteDogResponse
}

