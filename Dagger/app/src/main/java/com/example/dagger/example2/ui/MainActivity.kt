package com.example.dagger.example2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.dagger.R
import com.example.dagger.example1.Activity
import com.example.dagger.example2.ExampleApp
import com.example.dagger.example2.di.components.DaggerAppComponent
import com.example.dagger.example2.di.modules.DataModule
import com.example.dagger.example2.presentation.ExampleViewModel
import com.example.dagger.example2.presentation.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ExampleViewModel::class.java]
    }

    private val component by lazy {
        (application as ExampleApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.method()

    }
}