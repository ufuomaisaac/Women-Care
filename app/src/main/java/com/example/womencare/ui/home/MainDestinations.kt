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