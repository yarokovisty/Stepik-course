package com.example.dagger.example2.di.components

import android.content.Context
import com.example.dagger.example2.di.modules.DataModule
import com.example.dagger.example2.di.modules.DomainModule
import com.example.dagger.example2.ui.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, DomainModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)


    @Component.Factory
    interface AppComponentFactory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance timeMillis: Long
        ): AppComponent
    }
}