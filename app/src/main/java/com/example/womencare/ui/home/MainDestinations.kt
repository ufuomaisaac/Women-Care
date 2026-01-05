package com.example.womencare.ui.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Architecture
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Map
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.womencare.R

/*

sealed class MainBottomDestinations(
    var route: String,
    @StringRes var titleRes: Int,
    var icon: ImageVector
) {

    object Home: MainBottomDestinations(
        route = "overview",
        titleRes = R.string.home,
        icon = Icons.Filled.Home
    )



    object Library: MainBottomDestinations(
        route = "library",
        titleRes = R.string.library,
        icon = Icons.Filled.Book
    )
    object Image: MainBottomDestinations(
        route = "images",
        titleRes = R.string.images,
        icon = Icons.Filled.Architecture
    )

    object Map: MainBottomDestinations(
        route = "map",
        titleRes = R.string.maps,
        icon = Icons.Filled.LocationOn
    )
}

val BottomDestinationa = listOf(
    MainBottomDestinations.Home,
    MainBottomDestinations.Library,
    MainBottomDestinations.Image,
    MainBottomDestinations.Map
)
*/


sealed class MainBottomDestinations(
    val route: String,
    @StringRes val titleEn: Int,
    @StringRes val titleYo: Int,
    val icon: ImageVector
) {

    object Home : MainBottomDestinations(
        route = "overview",
        titleEn = R.string.home,
        titleYo = R.string.home_yo,
        icon = Icons.Filled.Home
    )

    object Library : MainBottomDestinations(
        route = "library",
        titleEn = R.string.library,
        titleYo = R.string.library_yo,
        icon = Icons.Filled.Book
    )

    object Image : MainBottomDestinations(
        route = "images",
        titleEn = R.string.images,
        titleYo = R.string.images_yo,
        icon = Icons.Filled.Architecture
    )

    object Map : MainBottomDestinations(
        route = "map",
        titleEn = R.string.maps,
        titleYo = R.string.maps_yo,
        icon = Icons.Filled.LocationOn
    )
}

val BottomDestinations = listOf(
    MainBottomDestinations.Home,
    MainBottomDestinations.Library,
    MainBottomDestinations.Image,
    MainBottomDestinations.Map
)

