package com.example.chatapp.main.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.main.domain.MainStartDestination

@Composable
fun App(startDestination: MainStartDestination) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination.route){
    }
}