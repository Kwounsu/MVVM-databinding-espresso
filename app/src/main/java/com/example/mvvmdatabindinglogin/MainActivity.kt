package com.example.mvvmdatabindinglogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmdatabindinglogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding> (this, R.layout.activity_main)
        val loginUser = LoginUser("","")
        binding.loginUser = loginUser
        val loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.loginViewModel = loginViewModel

        loginViewModel.loginResultLiveData.observe(this, Observer { loginResult ->
            if(loginResult) {
                Toast.makeText(this,"LOGIN SUCCESS",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"LOGIN FAILED",Toast.LENGTH_SHORT).show()
            }
        })
    }
}