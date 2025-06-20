package com.example.womencare.ui.screening

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class ScreeningViewModel : ViewModel() {

    private var _isPlanning = MutableStateFlow<Boolean>(false)
    val isPlanning: StateFlow<Boolean> get() = _isPlanning

    private var _hasGone = MutableStateFlow<Boolean>(false)
    val hasGone: StateFlow<Boolean> get() = _hasGone

    private var _selectedDate = MutableStateFlow<String>("")
    val selectedDate: StateFlow<String> get() = _selectedDate

}
