package com.example.mvvmdatabindinglogin

class LoginModel {
    fun login(id:String, password:String):Boolean {
        return id == "bob" && password == "123"
    }
}