package com.example.chatapp.main.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapp.app.util.AppConstants.SPLASH_SCREEN_DURATION
import com.example.chatapp.main.domain.GetStartDestinationUseCase
import com.example.chatapp.main.domain.MainStartDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getStartDestinationUseCase: GetStartDestinationUseCase
) : ViewModel() {
    private var _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    private var _startDestination: MutableState<MainStartDestination> = mutableStateOf(MainStartDestination.OnboardingScreen)
    val startDestination: State<MainStartDestination> = _startDestination

    init {
        onAppLaunches()
        updateStartDestination()
    }

    private fun onAppLaunches() {
        viewModelScope.launch {
            delay(SPLASH_SCREEN_DURATION)
            _isLoading.value = false
        }
    }

    private fun updateStartDestination() {
        viewModelScope.launch {
            getStartDestinationUseCase().collectLatest {
                _startDestination.value = it
            }
        }
    }
}