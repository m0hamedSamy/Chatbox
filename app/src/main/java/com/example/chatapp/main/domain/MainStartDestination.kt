package com.example.chatapp.main.domain

import com.example.chatapp.app.util.AppConstants.NAVIGATION_ROUTE_LOGIN
import com.example.chatapp.app.util.AppConstants.NAVIGATION_ROUTE_ONBOARDING

sealed class MainStartDestination(val route: String) {
    data object OnboardingScreen : MainStartDestination(NAVIGATION_ROUTE_ONBOARDING)
    data object LoginScreen : MainStartDestination(NAVIGATION_ROUTE_LOGIN)
}