import android.provider.ContactsContract.CommonDataKinds.Phone
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.womencare.ui.auth.signin.PhoneAuthScreen
import com.example.womencare.ui.auth.state.EmailState
import com.example.womencare.ui.auth.state.EmailStateSaver
import com.example.womencare.ui.auth.state.PasswordState
import com.example.womencare.ui.auth.viewmodel.AuthViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SignInScreen(
    navController: NavController,
    email: String = "",
    onSignInSubmitted: (email: String, password: String) -> Unit,
    onNavUp: () -> Unit,
    modifier: Modifier
) {

    Scaffold(
        topBar = {
            SignInTopAppBar(topAppBarTitle = "SignIn", NavUp = onNavUp)
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .padding(horizontal = 16.dp),

                    ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    SignInContent(
                        email = email,
                        onSignInSubmitted = onSignInSubmitted
                    )
                }
                TextButton(
                    modifier = Modifier,
                    buttonText = "Forgot password?",
                    onButtonClicked = {})

                PhoneAuthScreen(navController = navController)
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    )
}

@Composable
fun SignInContent(
    modifier: Modifier = Modifier,
    email: String,
    onSignInSubmitted: (email: String, password: String) -> Unit
) {

    var TAG = "NEWAGE"

    var isLoading by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        val focusRequester = remember { FocusRequester() }
        val emailState by rememberSaveable(stateSaver = EmailStateSaver) {
            mutableStateOf(EmailState(email))
        }
        val passwordState = remember { PasswordState() }
        val scope = rememberCoroutineScope()

        var authViewModel: AuthViewModel = hiltViewModel()
        var state = authViewModel.signInState.collectAsState()

        Email(emailState)
        Spacer(modifier = Modifier.height(16.dp))

        Password(
            label = "password",
            passwordState = passwordState,
            modifier = Modifier.focusRequester(focusRequester = focusRequester)
        )

        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (emailState.isValid && passwordState.isValid) {

                            //  authViewModel.signIn(emailState.text, passwordState.text)

                            isLoading = true

                            Log.d("NEWAGE", "button has been clicked")

                            scope.launch {

                                authViewModel.signIn(emailState.text, passwordState.text)

                                Log.d(TAG, "insideViewmodel ")
                                scope.launch {

                                    delay(3000)

                                    if (state.value) {
                                        onSignInSubmitted(emailState.text, passwordState.text)
                                        Log.d("NEWAGE", "Sign In Has been confirm ")
                                    } else {
                                        isLoading = false
                                        Toast.makeText(
                                            context,
                                            "unable to sign in user",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        Log.d("NEWAGE", "User is unable to sign in")
                                    }
                                }
                            }

                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp),
                    enabled = emailState.isValid && passwordState.isValid
                ) {
                    Text(
                        text = "Sign In",
                        color = Color.Black
                    )
                }

            }
        }
    }
}