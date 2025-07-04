
package com.example.womencare.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.womencare.ui.auth.signin.viewmodel.LanguageViewModel
import com.example.womencare.ui.auth.signin.NoAuthLoginScreen
import com.example.womencare.ui.home.Destinations.SIGN_IN_ROUTE
import com.example.womencare.ui.home.Destinations.MAIN_ROUTE

object Destinations{
    const val SIGN_UP_ROUTE = "signup"
    const val SIGN_IN_ROUTE = "signin"
    const val MAIN_ROUTE = "main"
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OnEntryNavigation(
    navController: NavHostController = rememberNavController(),
    languageViewModel: LanguageViewModel = hiltViewModel(),
    context: MainActivity
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.SIGN_IN_ROUTE
    ) {

        composable(route = SIGN_IN_ROUTE) {
            NoAuthLoginScreen(onLoginClick = { phoneNumber, name, city ->
                navController.navigate(route = MAIN_ROUTE)
                // Handle login click with the provided parameters
            },
                languageViewModel = languageViewModel,)
        }

        composable(route = MAIN_ROUTE) {
            MainScreen(context = context ,languageViewModel = languageViewModel)

        }

    }
}
