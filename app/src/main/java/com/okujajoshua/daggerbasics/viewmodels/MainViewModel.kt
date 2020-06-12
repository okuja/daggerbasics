package com.okujajoshua.daggerbasics.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.okujajoshua.daggerbasics.data.network.Api
import com.okujajoshua.daggerbasics.repository.UserRepository
import javax.inject.Inject

class MainViewModel(private val userRepository : UserRepository) : ViewModel() {

    private val _fullName = MutableLiveData<String>()

    val fullName: LiveData<String>
        get() = _fullName


    fun searchUser(username: String) {
        userRepository.getUser(
            username,
            {user ->_fullName.value = user.name},
            {t-> Log.e("MainActivity","onFailure",t)}
        )
    }
}


@Suppress("UNCHECKED_CAST")
class MainViewModelFactory @Inject constructor (private val userRepository: UserRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

