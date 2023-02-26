package com.sandy.login.mvvm.Interface

interface LoginResultCallBack {
    fun OnSuccess(message:String)
    fun OnError(message: String)
}