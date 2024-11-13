package com.example.aliaproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.example.aliaproject.Navigation.AppNavigation
import com.example.aliaproject.ui.theme.AliaProjectTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AliaProjectTheme {

                val navController = rememberNavController()

                Scaffold { paddingValues ->

                    AppNavigation(navController, paddingValues)
                }
            }
        }
    }
}
