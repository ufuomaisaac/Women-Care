package com.example.womencare.ui.auth.signin

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.material3.*
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse


@Composable
fun PhoneAuthScreen() {
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val response = IdpResponse.fromResultIntent(result.data)

        if (result.resultCode == Activity.RESULT_OK) {
            val user = FirebaseAuth.getInstance().currentUser
            Toast.makeText(context, "Signed in as: ${user?.phoneNumber}", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Sign-in failed: ${response?.error?.message}", Toast.LENGTH_LONG).show()
        }
    }

    Button(onClick = {
        val intent = getPhoneAuthIntent()
        launcher.launch(intent)
    }) {
        Text("Sign in with Phone")
    }
}

fun getPhoneAuthIntent(): Intent {
    val providers = listOf(
        AuthUI.IdpConfig.PhoneBuilder().build()
    )

    return AuthUI.getInstance()
        .createSignInIntentBuilder()
        .setAvailableProviders(providers)
        .build()
}