package com.example.vknewsclient.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vk.id.AccessToken
import com.vk.id.VKID
import com.vk.id.VKIDAuthFail
import com.vk.id.auth.VKIDAuthCallback
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Initial)
    val authState = _authState.asStateFlow()

    init {
        _authState.value = getAuthState()
    }

    private val vkidAuthCallback = object : VKIDAuthCallback {
        override fun onAuth(accessToken: AccessToken) {
            _authState.value = AuthState.Success(accessToken)
        }

        override fun onFail(fail: VKIDAuthFail) {
            _authState.value = AuthState.Fail(fail)
        }
    }

    private fun getAuthState(): AuthState {
        return if (VKID.instance.accessToken != null)  {
            AuthState.Authorized
        } else {
            AuthState.NotAuthorized
        }
    }

    fun authorize() {
        viewModelScope.launch {
            VKID.instance.authorize(vkidAuthCallback)
        }
    }
}