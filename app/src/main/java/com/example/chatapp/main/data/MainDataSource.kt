package com.example.chatapp.main.data

import com.example.chatapp.main.domain.MainStartDestination
import kotlinx.coroutines.flow.Flow


interface MainDataSource {
    fun getStartDestination(): Flow<MainStartDestination>
}