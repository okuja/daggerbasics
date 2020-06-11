package com.okujajoshua.daggerbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.okujajoshua.daggerbasics.data.network.Api
import com.okujajoshua.daggerbasics.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var fullName: TextView
    private lateinit var username: EditText
    private lateinit var search: Button

    @Inject
    lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        fullName = findViewById(R.id.full_name)
        username = findViewById(R.id.username)
        search = findViewById(R.id.search)


    }

    override fun onStart() {
        super.onStart()
        search.setOnClickListener {
            searchUser(username.text.toString())
        }
    }

    private fun searchUser(username: String) {
        api.getUser(username).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let { user ->
                    fullName.text = user.name
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("MainActivity", "onFailure: ", t)
            }
        })
    }
}
