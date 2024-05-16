package com.example.dagger.example2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger.R
import com.example.dagger.example1.Activity
import com.example.dagger.example2.di.components.DaggerAppComponent
import com.example.dagger.example2.di.modules.DataModule
import com.example.dagger.example2.presentation.ExampleViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: ExampleViewModel

    private val component by lazy {
        DaggerAppComponent.factory()
            .create(application, System.currentTimeMillis())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.method()

    }
}