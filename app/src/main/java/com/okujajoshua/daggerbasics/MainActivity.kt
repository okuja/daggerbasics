package com.okujajoshua.daggerbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.okujajoshua.daggerbasics.data.network.Api
import com.okujajoshua.daggerbasics.models.User
import com.okujajoshua.daggerbasics.viewmodels.MainViewModel
import com.okujajoshua.daggerbasics.viewmodels.MainViewModelFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var fullName: TextView
    private lateinit var username: EditText
    private lateinit var search: Button

    @Inject
    lateinit var factory: MainViewModelFactory

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        fullName = findViewById(R.id.full_name)
        username = findViewById(R.id.username)
        search = findViewById(R.id.search)

//        // Create the observer which updates the UI.
//        val nameObserver = Observer<String> { newName ->
//            // Update the UI, in this case, a TextView.
//            nameTextView.text = newName
//        }

        viewModel = ViewModelProvider(this,factory).get(MainViewModel::class.java)

        viewModel.fullName.observe(this, Observer { name ->
            fullName.text = name
        })

    }

    override fun onStart() {
        super.onStart()
        search.setOnClickListener {
            viewModel.searchUser(username.text.toString())
        }
    }

}
