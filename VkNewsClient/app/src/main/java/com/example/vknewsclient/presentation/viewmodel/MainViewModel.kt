package com.example.vknewsclient.presentation.viewmodel

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vknewsclient.presentation.state.AuthState
import com.vk.id.AccessToken
import com.vk.id.VKID
import com.vk.id.VKIDAuthFail
import com.vk.id.auth.VKIDAuthCallback
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _stateAuthScreen = MutableStateFlow<AuthState>(AuthState.Initial)
    val stateAuthScreen = _stateAuthScreen.asStateFlow()

    private val vkidAuthCallback = object : VKIDAuthCallback {
        override fun onAuth(accessToken: AccessToken) {
            _stateAuthScreen.value = AuthState.Authorized(accessToken)
        }

        override fun onFail(fail: VKIDAuthFail) {
            _stateAuthScreen.value = AuthState.Fail(fail)
        }
    }

    fun authorize(activity: Activity) {
        VKID.instance.authorize(activity, vkidAuthCallback)
    }
}