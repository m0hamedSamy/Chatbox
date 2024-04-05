package com.example.chatapp.app.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.chatapp.app.util.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(AppConstants.USER_PREFERENCES)
    @Provides
    @Singleton
    fun providePreferencesDataStore(@ApplicationContext context: Context): DataStore<Preferences> = context.dataStore

}