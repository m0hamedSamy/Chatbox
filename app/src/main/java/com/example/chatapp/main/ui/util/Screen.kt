package com.example.chatapp.main.ui.util

import com.example.chatapp.app.util.AppConstants.NAVIGATION_ROUTE_ONBOARDING

sealed class Screen(val route: String){
    data object Onboarding : Screen(NAVIGATION_ROUTE_ONBOARDING)
}