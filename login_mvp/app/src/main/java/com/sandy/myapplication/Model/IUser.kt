package com.sandy.myapplication.Model

interface IUser {

    val email:String
    val password:String
    fun isDataValid():Int

}