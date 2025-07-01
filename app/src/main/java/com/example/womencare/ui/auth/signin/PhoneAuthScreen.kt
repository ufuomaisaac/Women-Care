package com.example.womencare.ui.auth.signin

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.PhoneAuthProvider
// Dependencies
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.womencare.R
import com.example.womencare.ui.home.Destinations.MAIN_ROUTE
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit



@Composable
fun PhoneAuthScreen(navController: NavController, modifier: Modifier) {
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val response = IdpResponse.fromResultIntent(result.data)

        if (result.resultCode == Activity.RESULT_OK) {
            val user = FirebaseAuth.getInstance().currentUser
            Toast.makeText(context, "Signed in as: ${user?.phoneNumber}", Toast.LENGTH_LONG).show()
            navController.navigate(MAIN_ROUTE)
        } else {
            Toast.makeText(context, "Sign-in failed: ${response?.error?.message}", Toast.LENGTH_LONG).show()

        }
    }

    Button(modifier = modifier. padding(16.dp),
        onClick = {
        val intent = getPhoneAuthIntent()
        launcher.launch(intent)
    }) {
        Text("Sign in with Phone Number ")
    }
}

fun getPhoneAuthIntent(): Intent {
    val providers = listOf(
        AuthUI.IdpConfig.PhoneBuilder().build()
    )

    return AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setAvailableProviders(providers)
        .setTheme(R.style.CustomFirebaseUITheme)
        .build()
}

