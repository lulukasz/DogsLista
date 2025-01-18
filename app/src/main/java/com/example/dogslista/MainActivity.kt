package com.example.dogslista

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.dogslista.navigation.MainNavigation
import com.example.dogslista.ui.theme.DogsListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogsListApp()
        }
    }
}

@Composable
fun DogsListApp() {
    DogsListTheme {
        val navController = rememberNavController()
        MainNavigation(navController = navController)
    }
}
