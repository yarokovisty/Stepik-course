package com.example.dagger.example2.di.components

import com.example.dagger.example2.di.annotations.IdQualifier
import com.example.dagger.example2.di.annotations.NameQualifier
import com.example.dagger.example2.di.modules.ViewModelModule
import com.example.dagger.example2.ui.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named

@Subcomponent(
    modules = [ViewModelModule::class]
)
interface ActivityComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance @IdQualifier id: String,
            @BindsInstance @NameQualifier name: String
        ): ActivityComponent
    }
}