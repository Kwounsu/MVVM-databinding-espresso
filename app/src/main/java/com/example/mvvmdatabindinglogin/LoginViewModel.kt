package com.example.mvvmdatabindinglogin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    var _loginResultLiveData : MutableLiveData<Boolean> = MutableLiveData()
    val loginResultLiveData : LiveData<Boolean> = _loginResultLiveData

    fun login(id:String, password:String) {
        val loginModel = LoginModel()
        if (loginModel.login(id, password)) _loginResultLiveData.postValue(true)
        else _loginResultLiveData.postValue(false)
    }
}