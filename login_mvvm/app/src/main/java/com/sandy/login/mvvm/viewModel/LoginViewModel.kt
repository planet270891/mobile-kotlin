package com.sandy.login.mvvm.viewModel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.sandy.login.mvvm.Interface.LoginResultCallBack
import com.sandy.login.mvvm.Model.User


class LoginViewModel(private val listener: LoginResultCallBack) : ViewModel() {

    private val user: User

    init {
        this.user = User("","")
    }

    val emailTextWatcher: TextWatcher
        get() = object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                user.setEmail(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }

    val passwordTextWatcher:TextWatcher
        get() = object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                user.setPassword(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }

    fun onLoginClicked(v: View){
       var loginCode:Int = user.isDataValid()
       if(loginCode == 0){
            listener.OnError("Email must not be null")
       }else if(loginCode == 1){
           listener.OnError("Wrong email pattern")
       }else if(loginCode == 2){
           listener.OnError("Password length must greater than 6")
       }else{
           listener.OnSuccess("Login Success")
       }
    }

}