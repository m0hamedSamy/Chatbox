package com.example.chatapp.main.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp.main.domain.MainStartDestination
import com.example.chatapp.main.ui.util.Screen
import com.example.chatapp.onboarding.ui.OnboardingScreen

@Composable
fun App(startDestination: MainStartDestination) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination.route){
        composable(route = Screen.Onboarding.route) {
            OnboardingScreen(
                onSignUpClick = {  },
                onLogInClick = {  },
                onSignUpWithFacebookClick = {  },
                onSignUpWithGoogleClick = {  },
            )
        }
    }
}