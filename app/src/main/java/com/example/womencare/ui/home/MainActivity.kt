package com.example.womencare.ui.home

import SignInScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mothercare.ui.scene.auth.signup.SignUpScreen
import com.example.womencare.theme.WomenCareTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WomenCareTheme {
                Surface {
                       /* SignInScreen(
                            onSignInSubmitted = {_, _ -> },
                            onNavUp = {  },
                            modifier = Modifier)*/

                    SignUpScreen(
                        modifier = Modifier,
                        onSignUpSubmitted = { }) {
                    }
                }
            }
        }
    }
}


@Composable
fun  MainScreen(context: MainActivity) {
    var navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var currentDestinations = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.DarkGray
            ) {
                BottomDestinationa.forEach { destination ->
                    BottomNavigationItem(
                        selected = destination.route == currentDestinations?.route,
                        icon = {
                            Icon(imageVector = destination.icon, contentDescription = "")
                        },
                        alwaysShowLabel = false,
                        label = {
                            Text(text = stringResource(destination.titleRes),
                                color = Color.White)
                        },

                        onClick = {
                            navController.navigate(destination.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        },
                    )
                }
            }
        }
    ) {padding ->
        NavHost(navController = navController,
            startDestination = MainBottomDestinations.Home.route,
            modifier = Modifier.padding(padding)) {

            composable(MainBottomDestinations.Home.route) {
                /* HomeScreen(
                     navController = navController,
                     onNavigateToReward = { *//*TODO*//* },
                   userName = "Ufuoma",
                   userCredit = "123",
                   context = context
               )*/
            }

            /*composable(MainBottomDestinations.Map.route) {
                *//* val intent = Intent(context, ChatbotActivity::class.java)
                 context.startActivity(intent)*//*
                ChatRoute()
            }
            composable(MainBottomDestinations.Library.route) {
                UserProfile(navController = navController)
            }

            composable(Articles.CheckUpScreen.name) {

            }

            composable(Articles.FirstArticle.name) {
                ArticleItem(imageIdRes = R.drawable.ab3_stretching, firstTextIdRes = R.string.first_article,
                    topic = "Balancing Nutrients", navController = navController )
            }
            composable(Articles.SecondArticle.name) {
                ArticleItem(imageIdRes = R.drawable.ab2_quick_yoga, firstTextIdRes = R.string.second_article,
                    topic = "Embracing Your Changing Body", navController = navController )

            }
            composable(Articles.ThirdArticle.name) {
                ArticleItem(imageIdRes = R.drawable.ab6_pre_natal_yoga, firstTextIdRes = R.string.third_article,
                    topic = "Overcoming Pregnancy Depression", navController = navController )
            }
            composable(Articles.FourthArticle.name) {
                ArticleItem(imageIdRes = R.drawable.ab3_stretching, firstTextIdRes = R.string.first_article,
                    topic = "Exercise", navController = navController )
            }
            composable(Articles.FifthArticle.name) {
                ArticleItem(imageIdRes = R.drawable.ab3_stretching, firstTextIdRes = R.string.first_article,
                    topic = "Exercise", navController = navController )
            }*/
        }
    }
}


