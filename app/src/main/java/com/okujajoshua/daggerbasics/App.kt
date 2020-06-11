package com.okujajoshua.daggerbasics

import android.app.Application
import com.okujajoshua.daggerbasics.dagger.AppComponent
import com.okujajoshua.daggerbasics.dagger.DaggerAppComponent

class App : Application(){

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent
            .builder()
            .build()
    }

}

lateinit var component : AppComponent