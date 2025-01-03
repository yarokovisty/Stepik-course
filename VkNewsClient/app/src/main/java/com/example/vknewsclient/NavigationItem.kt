package com.example.vknewsclient

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    val titleResId: Int,
    val icon: ImageVector
) {

    object Home : NavigationItem(
        titleResId = R.string.navigation_item_main,
        icon = Icons.Outlined.Home
    )

    object Favourite : NavigationItem(
        titleResId = R.string.navigation_item_favourite,
        icon = Icons.Outlined.Favorite
    )

    object Profile : NavigationItem(
        titleResId = R.string.navigation_item_profile,
        icon = Icons.Outlined.Person
    )
}