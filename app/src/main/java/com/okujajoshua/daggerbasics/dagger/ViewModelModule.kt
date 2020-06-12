package com.okujajoshua.daggerbasics.dagger

import com.okujajoshua.daggerbasics.data.network.Api
import com.okujajoshua.daggerbasics.repository.UserRepository
import com.okujajoshua.daggerbasics.viewmodels.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun providesMainViewModelFactory(userRepository: UserRepository): MainViewModelFactory {
        return MainViewModelFactory(userRepository)
    }
}