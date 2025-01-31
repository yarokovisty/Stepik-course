package com.example.vknewsclient.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vknewsclient.presentation.state.AuthState
import com.example.vknewsclient.presentation.viewmodel.MainViewModel
import com.example.vknewsclient.ui.theme.VkNewsClientTheme
import com.vk.id.VKID

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            VkNewsClientTheme {
                val viewModel: MainViewModel = viewModel()
                val authState = viewModel.stateAuthScreen.collectAsState()

                when (authState.value) {
                    AuthState.Initial -> {

                    }
                    is AuthState.Authorized -> {
                        MainScreen()
                    }
                    is AuthState.Fail -> {
                        LoginScreen()
                    }
                }
            }
        }
    }
}

