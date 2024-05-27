package com.example.myapplication.presentation

import android.app.Application
import com.example.myapplication.di.component.DaggerAppComponent

class ShopApplication : Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}