package com.example.womencare.ui.screening

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ScreeningViewModel @Inject constructor(): ViewModel() {

    private var _isPlanning = MutableStateFlow<Boolean>(false)
    val isPlanning: StateFlow<Boolean> get() = _isPlanning

    private var _hasGone = MutableStateFlow<Boolean>(false)
    val hasGone: StateFlow<Boolean> get() = _hasGone

    private var _selectedDate = MutableStateFlow<String>("")
    val selectedDate = _selectedDate.asStateFlow()


    fun getUserSelectedDate(selectedDate : String) {
        _selectedDate.value = selectedDate
    }

    fun setSelectedDate(selectedDate: String) {
        _selectedDate.value = selectedDate
    }
}
