package com.example.dogslista.ui.navigation

import com.example.dogslista.data.Dog

sealed class Screen {
    object Main : Screen()
    data class DogDetail(val dog: Dog) : Screen()
    object Settings : Screen()
    object Profile : Screen()
}

