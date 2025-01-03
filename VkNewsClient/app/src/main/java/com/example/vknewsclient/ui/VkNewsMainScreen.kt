package com.example.vknewsclient.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.vknewsclient.NavigationItem
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var fabIsVisible by remember { mutableStateOf(true) }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                var selectedItemPosition by remember { mutableIntStateOf(0) }
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemPosition == index,
                        onClick = { selectedItemPosition = index },
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
        },
        floatingActionButton = {
            if (fabIsVisible) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            val action = snackBarHostState.showSnackbar(
                                message = "This is snackbar",
                                actionLabel = "Hide FAB",
                                duration = SnackbarDuration.Long
                            )
                            if (action == SnackbarResult.ActionPerformed) {
                                fabIsVisible = false
                            }
                        }
                    }
                ) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }
    ) {}
}