package com.example.womencare.ui.auth.signin.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor() : ViewModel() {

    // Backing state
    private val _isYoruba = MutableStateFlow(false)
    val isYoruba: StateFlow<Boolean> = _isYoruba

    // Toggle language
    fun toggleLanguage() {
        _isYoruba.value = !_isYoruba.value
    }

    // Optional: explicitly set language
    fun setLanguage(isYoruba: Boolean) {
        _isYoruba.value = isYoruba
    }
}
