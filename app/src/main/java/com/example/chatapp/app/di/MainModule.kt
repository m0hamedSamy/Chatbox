package com.example.chatapp.app.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.chatapp.main.data.MainDataSource
import com.example.chatapp.main.data.MainDataSourceImpl
import com.example.chatapp.main.data.MainRepositoryImpl
import com.example.chatapp.main.domain.MainRepository
import com.example.chatapp.main.domain.GetStartDestinationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object MainModule {
    @Provides
    fun provideMainDataSource(userPreferences: DataStore<Preferences>): MainDataSource =
        MainDataSourceImpl(userPreferences)

    @Provides
    fun provideMainRepository(dataSource: MainDataSource): MainRepository =
        MainRepositoryImpl(dataSource)

    @Provides
    fun provideGetStartDestinationUseCase(repository: MainRepository): GetStartDestinationUseCase =
        GetStartDestinationUseCase(repository)
}