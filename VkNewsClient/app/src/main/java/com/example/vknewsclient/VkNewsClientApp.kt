package com.example.vknewsclient

import android.app.Application
import com.vk.id.VKID

class VkNewsClientApp : Application() {

    override fun onCreate() {
        super.onCreate()
        VKID.init(this)
    }
}