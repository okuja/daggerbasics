package com.okujajoshua.daggerbasics.dagger

import com.okujajoshua.daggerbasics.data.network.Api
import com.okujajoshua.daggerbasics.repository.UserRepository
import com.okujajoshua.daggerbasics.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesUserRepository(api: Api) : UserRepository{
        return UserRepositoryImpl(api)
    }
}