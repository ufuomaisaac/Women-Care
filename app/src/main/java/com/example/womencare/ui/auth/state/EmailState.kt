package com.example.womencare.ui.auth.state

import java.util.regex.Pattern

// Consider an email valid if there's some text before and after a "@"
private const val EMAIL_VALIDATION_REGEX = "^(.+)@(.+)\$"

class EmailState(var email : String? = null):
    TextFieldState(validator = ::isEmailValid, errorFor = ::emailValidationError ){

    init {
        email?.let {
            text = it
        }
    }
}

fun isEmailValid(email: String): Boolean {
    return Pattern.matches(EMAIL_VALIDATION_REGEX, email)
}
/**
 * Returns an error to be displayed or null if no error was found
 */
fun emailValidationError(email : String): String {
    return "Invalid email $email"
}

val EmailStateSaver = textFieldStateSaver(EmailState())