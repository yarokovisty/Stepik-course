package com.example.myapplication.di.component

import android.app.Application
import com.example.myapplication.data.contentprovider.ShopListProvider
import com.example.myapplication.di.module.DataModule
import com.example.myapplication.di.module.ViewModelModule
import com.example.myapplication.di.scope.AppScope
import com.example.myapplication.ui.MainActivity
import com.example.myapplication.ui.ShopItemFragment
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: ShopItemFragment)
    fun inject(provider: ShopListProvider)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }
}