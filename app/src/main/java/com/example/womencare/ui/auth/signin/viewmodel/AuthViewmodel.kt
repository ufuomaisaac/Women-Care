package com.example.womencare.ui.auth.signin.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.womencare.ui.auth.state.AuthUiState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class  AuthViewModel @Inject constructor(
    private var auth: FirebaseAuth
): ViewModel() {

    private var _signInState = MutableStateFlow<Boolean>(false)
    val signInState: StateFlow<Boolean>
        get() = _signInState.asStateFlow()


    private var _signUpState = MutableStateFlow<Boolean>(false)
    val signUpState: StateFlow<Boolean>

        get() = _signUpState.asStateFlow()

    //This is currently not in use, although it has a receiver(SignInScreen)
    private val _uiState: MutableStateFlow<AuthUiState> = MutableStateFlow(AuthUiState.Initial)
    val uiState: StateFlow<AuthUiState> =
        _uiState.asStateFlow()

    private var _authUiState = MutableStateFlow<AuthUiState>(AuthUiState.Initial)
    val authUiState : StateFlow<AuthUiState>

        get() = _authUiState.asStateFlow()


    fun signIn(email: String, password: String) = viewModelScope.launch() {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->

                if (task.isSuccessful) {

                    _signInState.value = true
                    Log.d("NEWAGE", "success")

                } else {
                    _signInState.value = false
                    Log.d("NEWAGE", "failed")
                }

            }
    }

    fun signUp(email: String, password: String) = viewModelScope.launch {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {task ->

                if(task.isSuccessful) {
                    // AuthState(signedUp = true)
                    _signUpState.value = true

                } else  {
                    _signUpState.value = false

                }
            }
    }
}