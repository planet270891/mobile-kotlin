package com.sandy.login.mvvm.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sandy.login.mvvm.Interface.LoginResultCallBack


class LoginViewModelFactory (private val listener: LoginResultCallBack) : ViewModelProvider.NewInstanceFactory() {
    override fun <T: ViewModel?> create(modelClass: Class<T>) : T{
       return LoginViewModel(listener) as T
    }
}