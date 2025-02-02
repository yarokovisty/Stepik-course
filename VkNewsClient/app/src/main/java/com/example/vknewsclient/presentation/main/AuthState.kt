package com.example.vknewsclient.presentation.main

import com.vk.id.AccessToken
import com.vk.id.VKIDAuthFail

sealed interface AuthState {

    object Initial : AuthState

    object NotAuthorized : AuthState

    object Authorized : AuthState

    class Success(accessToken: AccessToken) : AuthState

    class Fail(fail: VKIDAuthFail) : AuthState

}