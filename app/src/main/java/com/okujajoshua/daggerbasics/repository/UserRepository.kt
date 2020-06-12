package com.okujajoshua.daggerbasics.repository

import com.okujajoshua.daggerbasics.models.User

interface UserRepository {

    fun getUser(username: String, onSuccess: (user: User) -> Unit, onFailure: (t: Throwable) -> Unit)
}