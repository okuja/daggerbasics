package com.okujajoshua.daggerbasics.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.okujajoshua.daggerbasics.data.network.Api
import com.okujajoshua.daggerbasics.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val api: Api) : ViewModel() {

    private val _fullName = MutableLiveData<String>()

    val fullName: LiveData<String>
        get() = _fullName

    fun searchUser(username: String) {
        api.getUser(username).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let { user ->
                    _fullName.value = user.name
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("MainActivity", "onFailure: ", t)
            }
        })
    }
}

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val api: Api) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(api) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

