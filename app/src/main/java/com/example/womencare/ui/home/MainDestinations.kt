package com.example.womencare.ui.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
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

     object Map: MainBottomDestinations(
         route = "map",
         titleRes = R.string.maps,
         icon = Icons.Filled.LocationOn
     )

    object Library: MainBottomDestinations(
        route = "library",
        titleRes = R.string.library,
        icon = Icons.Filled.Book
    )
}

val BottomDestinationa = listOf(
    MainBottomDestinations.Home,
    MainBottomDestinations.Map,
    MainBottomDestinations.Map
)