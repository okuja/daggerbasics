package com.okujajoshua.daggerbasics.dagger

import com.okujajoshua.daggerbasics.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        ViewModelModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    fun inject(activity : MainActivity)
}