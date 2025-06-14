import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.womencare.theme.WomenCareTheme
import com.example.womencare.ui.auth.state.EmailState
import com.example.womencare.ui.auth.state.TextFieldState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInTopAppBar(
    topAppBarTitle: String,
    NavUp: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = topAppBarTitle,
                modifier = Modifier
            )
        },
        navigationIcon = {
            IconButton(onClick = NavUp) {
                Icon(imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "navigation icon")
            }
        }
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun SignUpTopAppBar(
    topAppBarTitle: String,
    NavUp: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = topAppBarTitle,
                modifier = Modifier
            )
        }
    )
}

@Composable
fun Email(
    emailState: TextFieldState =  remember { EmailState() },
    imeAction: ImeAction = ImeAction.Next,
    onImeAction: () -> Unit = {}
) {
    OutlinedTextField(
        value = emailState.text.toString(),
        onValueChange = {
            emailState.text = it
        },
        label = {
            Text(text = "email",)
               // style = Typography.)
        },
        modifier = Modifier
            .fillMaxWidth()
            .onFocusChanged { focusState ->
                emailState.onFocusChange(focusState.isFocused)
                if (!focusState.isFocused) {
                    emailState.enableShowErrors()
                }
            },
        textStyle = MaterialTheme.typography.bodyMedium,
        isError = emailState.showErrors(),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = imeAction,
            keyboardType = KeyboardType.Email
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onImeAction()
            }
        ),
        singleLine = true
    )
    emailState.getError()?.let { error -> TextFieldError(textError = error) }
}


@Composable
fun Password(
    label: String,
    passwordState: TextFieldState,
    modifier: Modifier = Modifier,
    imeAction: ImeAction = ImeAction.Done,
    onImeAction: () -> Unit = {}
) {

    val showPassword = rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(value = passwordState.text,
        onValueChange = {
            passwordState.text = it
            passwordState.enableShowErrors()
        },
        modifier = modifier
            .fillMaxWidth()
            .onFocusChanged { focusState ->
                passwordState.onFocusChange(focusState.isFocused)
                if (!focusState.isFocused) {
                    passwordState.enableShowErrors()
                }
            },
        textStyle = MaterialTheme.typography.bodyMedium,
        label = {
            Text(text = label,
                style = MaterialTheme.typography.bodyMedium)
        },
        trailingIcon = {
            if (showPassword.value) {
                IconButton(onClick = { showPassword.value = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "hide password"
                    )
                }
            } else {
                IconButton(onClick = { showPassword.value = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = "show password")
                }
            }
        },
        visualTransformation = if (showPassword.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        isError = passwordState.showErrors(),

        )

}

@Composable
fun TextFieldError(textError: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = textError,
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.error
        )
    }
}

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    onButtonClicked: () -> Unit,
    buttonText: String) {

    TextButton(
        onClick = onButtonClicked,
    ) {
        Text(
            text = buttonText,
            color = Color.Black
        )
    }
}

@Composable
fun CityInputField(
    city: String,
    onCityChange: (String) -> Unit
) {
    OutlinedTextField(
        value = city,
        onValueChange = onCityChange,
        label = { Text("Enter City") },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Preview()
@Composable
fun SignUpContentPreview() {
    WomenCareTheme {
        Surface {
            SignInScreen(onSignInSubmitted = {_, _ -> }, onNavUp = {  }, modifier = Modifier)
        }
    }
}

