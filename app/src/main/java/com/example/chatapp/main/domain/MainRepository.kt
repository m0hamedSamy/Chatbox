package com.example.chatapp.main.domain

import kotlinx.coroutines.flow.Flow


interface MainRepository {
    fun getStartDestination(): Flow<MainStartDestination>
}