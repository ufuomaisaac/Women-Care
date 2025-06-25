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
import com.example.womencare.R
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit



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
        .setTheme(R.style.CustomFirebaseUITheme)
        .build()
}

@Composable
fun PhoneAuthScreen(activity: Activity) {
    var phoneNumber by remember { mutableStateOf("") }
    var codeSent by remember { mutableStateOf(false) }
    var verificationId by remember { mutableStateOf<String?>(null) }
    var otpCode by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    val auth = Firebase.auth

    val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            // Auto-retrieved or instant verification
            auth.signInWithCredential(credential)
                .addOnCompleteListener { task ->
                    message = if (task.isSuccessful) "Verification Successful!" else "Auto-verification failed"
                }
        }

        override fun onVerificationFailed(e: FirebaseException) {
            message = "Verification Failed: ${e.message}"
        }

        override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
            verificationId = id
            codeSent = true
            message = "Code sent to $phoneNumber"
        }
    }


    Column(modifier = Modifier.padding(16.dp)) {
        if (!codeSent) {
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Phone Number (+234...)") }
            )
            Spacer(Modifier.height(16.dp))
            Button(onClick = {
                val options = PhoneAuthOptions.newBuilder(auth)
                    .setPhoneNumber(phoneNumber)
                    .setTimeout(60L, TimeUnit.SECONDS)
                    .setActivity(activity)
                    .setCallbacks(callbacks)
                    .build()
                PhoneAuthProvider.verifyPhoneNumber(options)
            }) {
                Text("Send Verification Code")
            }
        } else {
            OutlinedTextField(
                value = otpCode,
                onValueChange = { otpCode = it },
                label = { Text("Enter OTP Code") }
            )
            Spacer(Modifier.height(16.dp))
            Button(onClick = {
                verificationId?.let {
                    val credential = PhoneAuthProvider.getCredential(it, otpCode)
                    auth.signInWithCredential(credential)
                        .addOnCompleteListener { task ->
                            message = if (task.isSuccessful) "Login successful!" else "Invalid code!"
                        }
                }
            }) {
                Text("Verify Code")
            }
        }

        Spacer(Modifier.height(24.dp))
        Text(text = message)
    }
}
