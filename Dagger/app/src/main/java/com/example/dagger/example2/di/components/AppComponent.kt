package com.example.dagger.example2.di.components

import android.content.Context
import com.example.dagger.example2.di.modules.DataModule
import com.example.dagger.example2.di.modules.DomainModule
import com.example.dagger.example2.di.modules.ViewModelModule
import com.example.dagger.example2.di.scopes.AppScope
import com.example.dagger.example2.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@AppScope
@Component(modules = [DataModule::class, DomainModule::class, ViewModelModule::class])
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