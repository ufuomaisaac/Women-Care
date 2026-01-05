package com.example.womencare.ui.home

import ScreeningTrackerScreen
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.womencare.R
import com.example.womencare.theme.WomenCareTheme
import com.example.womencare.ui.auth.signin.viewmodel.LanguageViewModel
import com.example.womencare.ui.library.ArticleItem
import com.example.womencare.ui.library.Articles
import com.example.womencare.ui.library.CervicalCancerInfoScreen
import com.example.womencare.ui.library.CounselingFlowScreen
import com.example.womencare.ui.library.ImageScrollScreen
import com.example.womencare.ui.library.TwoImagesFullVertical


import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WomenCareTheme {
                Surface {
                    OnEntryNavigation(context = this)
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun  MainScreen(
    context: MainActivity,
    languageViewModel: LanguageViewModel
) {

    val isYoruba by languageViewModel.isYoruba.collectAsState()

    var navController: NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var currentDestinations = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.LightGray
            ) {
                BottomDestinations.forEach { destination ->

                    val selected = destination.route == currentDestinations?.route

                    BottomNavigationItem(
                        selected = selected,
                        icon = {
                            Icon(
                                imageVector = destination.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(
                                    id = if (isYoruba) {
                                        destination.titleYo
                                    } else {
                                        destination.titleEn
                                    }
                                ),
                                fontSize = 10.sp
                            )
                        },
                        onClick = {
                            if (!selected) {
                                navController.navigate(destination.route) {
                                    popUpTo(
                                        navController.graph.findStartDestination().id
                                    ) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { padding ->
        // Your NavHost / screen content
    NavHost(navController = navController,
            startDestination = MainBottomDestinations.Home.route,
            modifier = Modifier.padding(padding)) {

            composable(MainBottomDestinations.Home.route) {
                CounselingFlowScreen(languageViewModel = languageViewModel)

            }

            composable(MainBottomDestinations.Library.route) {
                CervicalCancerInfoScreen(navController = navController,languageViewModel = languageViewModel)
            }

            composable(route = MainBottomDestinations.Image.route) {
                //ImageScrollScreen()
                TwoImagesFullVertical()


            }

            composable(MainBottomDestinations.Map.route) {
                ScreeningTrackerScreen(languageViewModel = languageViewModel)

            }

            composable(Articles.FirstArticle.name) {
                ArticleItem(imageIdRes = R.drawable.ab3_stretching, firstTextIdRes = R.string.article_warning_signs,
                    topic = "Balancing Nutrients", navController = navController )
            }
            composable(Articles.SecondArticle.name) {
                ArticleItem(imageIdRes = R.drawable.ab2_quick_yoga, firstTextIdRes = R.string.second_article,
                    topic = "Embracing Your Changing Body", navController = navController )

            }

        }
    }
}


