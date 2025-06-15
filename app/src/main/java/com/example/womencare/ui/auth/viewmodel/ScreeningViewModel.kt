package com.example.womencare.ui.auth.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
class ScreeningViewModel : ViewModel() {

    // Backing field (private setter)
    private var _isPlanning = MutableStateFlow<Boolean>(false)
    val isPlanning: MutableStateFlow<Boolean> get() = _isPlanning

    private var _hasGone = MutableStateFlow<Boolean>(false)
    val hasGone: MutableStateFlow<Boolean> get() = _hasGone

    private var _selectedDate = MutableStateFlow<String>("")
    val selectedDate: String get() = _selectedDate.toString()

    /*// Update functions
    fun setIsPlanning(value: Boolean) {
        _isPlanning = value
    }

    fun setHasGone(value: Boolean) {
        _hasGone = value
    }

    fun setSelectedDate(value: String) {
        _selectedDate = value
    }*/
}
