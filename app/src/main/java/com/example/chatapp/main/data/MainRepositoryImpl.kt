package com.example.chatapp.main.data

import com.example.chatapp.main.domain.MainStartDestination
import com.example.chatapp.main.domain.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(private val dataSource: MainDataSource) :
    MainRepository {

    override fun getStartDestination(): Flow<MainStartDestination> {
        return dataSource.getStartDestination()
    }
}