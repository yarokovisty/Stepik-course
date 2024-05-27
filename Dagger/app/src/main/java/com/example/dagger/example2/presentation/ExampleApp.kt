package com.example.dagger.example2.presentation

import android.app.Application
import com.example.dagger.example2.di.components.DaggerAppComponent

class ExampleApp : Application() {

    val component by lazy {
        DaggerAppComponent.factory()
            .create(this, System.currentTimeMillis())
    }

}