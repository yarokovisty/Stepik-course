package com.example.vknewsclient.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vknewsclient.presentation.main.AuthState
import com.example.vknewsclient.presentation.main.MainViewModel
import com.example.vknewsclient.ui.theme.VkNewsClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            VkNewsClientTheme {
                val viewModel: MainViewModel = viewModel()
                val authState = viewModel.authState.collectAsState()

                when (authState.value) {
                    AuthState.NotAuthorized -> {
                        LoginScreen { viewModel.authorize() }
                    }
                    is AuthState.Authorized -> {
                        MainScreen()
                    }
                    is AuthState.Success -> {
                        MainScreen()
                    }
                    else -> {

                    }
                }
            }
        }
    }
}

