package com.example.dogslista.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteDogResponse(
    val message: String,
    val status: String
)

