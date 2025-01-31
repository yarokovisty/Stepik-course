package com.example.vknewsclient.presentation.state

import com.vk.id.AccessToken
import com.vk.id.VKIDAuthFail

sealed interface AuthState {

    object Initial : AuthState

    class Authorized(accessToken: AccessToken) : AuthState

    class Fail(fail: VKIDAuthFail) : AuthState
}