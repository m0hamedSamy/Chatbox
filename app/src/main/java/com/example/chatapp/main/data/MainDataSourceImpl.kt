package com.example.chatapp.main.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.chatapp.app.util.AppConstants.NAVIGATION_ROUTE_LOGIN
import com.example.chatapp.app.util.AppConstants.STRING_PREF_KEY_START_DESTINATION_NAVIGATION_ROUTE
import com.example.chatapp.main.domain.MainStartDestination
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainDataSourceImpl @Inject constructor(private val userPreferences: DataStore<Preferences>) :
    MainDataSource {

    private val startDestinationKey = stringPreferencesKey(STRING_PREF_KEY_START_DESTINATION_NAVIGATION_ROUTE)

    override fun getStartDestination(): Flow<MainStartDestination> {
        return userPreferences.data.map { preferences ->
            when(preferences[startDestinationKey]){
                NAVIGATION_ROUTE_LOGIN -> MainStartDestination.LoginScreen
                else -> MainStartDestination.OnboardingScreen
            }
        }
    }
}