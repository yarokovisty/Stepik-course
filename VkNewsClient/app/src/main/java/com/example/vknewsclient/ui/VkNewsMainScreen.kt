package com.example.vknewsclient.ui

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.vknewsclient.NavigationItem
import com.example.vknewsclient.navigation.AppNavGraph
import com.example.vknewsclient.navigation.NavigationState
import com.example.vknewsclient.navigation.rememberNavigationState

@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()

    Scaffold(
        bottomBar = {
            VkBottomBar(navigationState)
        }
    ) { paddingValues ->
        AppNavGraph(
            navHostController = navigationState.navHostController,
            newsFeedScreenContent = {
                HomeScreen(
                    paddingValues = paddingValues,
                    onCommentClickListener = {
                        navigationState.navigateToComments(it)
                    }
                )
            },
            commentsScreenContent = { feedPost ->
                CommentsScreen(
                    onBackPressed = { navigationState.navHostController.popBackStack() },
                    feedPost = feedPost
                )
            },
            favouriteScreenContent = { Text("favorite") },
            profileScreenContent = { Text("profile") }
        )
    }
}

@Composable
private fun VkBottomBar(
    navigationState: NavigationState
) {
    BottomAppBar {
        val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
        val items = listOf(
            NavigationItem.Home,
            NavigationItem.Favourite,
            NavigationItem.Profile
        )
        items.forEach { item ->
            val selected = navBackStackEntry?.destination?.hierarchy?.any {
                it.route == item.screen.route
            } ?: false
            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        navigationState.navigateTo(item.screen.route)
                    }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = null)
                },
                label = {
                    Text(text = stringResource(item.titleResId))
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = Color.Blue,
                    unselectedIconColor = Color.Gray,
                    disabledIconColor = Color.LightGray,
                    selectedTextColor = Color.Blue,
                    unselectedTextColor = Color.Gray,
                    disabledTextColor = Color.LightGray,
                    selectedIndicatorColor = Color.Transparent
                )
            )
        }
    }
}