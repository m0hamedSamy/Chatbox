package com.example.chatapp.main.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStartDestinationUseCase @Inject constructor(private val repository: MainRepository) {
    operator fun invoke(): Flow<MainStartDestination> {
        return repository.getStartDestination()
    }
}