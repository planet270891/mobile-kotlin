package com.sandy.login.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sandy.login.mvvm.Interface.LoginResultCallBack
import com.sandy.login.mvvm.R
import com.sandy.login.mvvm.viewModel.LoginViewModel
import com.sandy.login.mvvm.viewModel.LoginViewModelFactory
import com.sandy.login.mvvm.databinding.ActivityMainBinding
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(), LoginResultCallBack {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBiding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        activityMainBiding.viewModel = ViewModelProviders.of(this, LoginViewModelFactory(this))
            .get(LoginViewModel::class.java)
    }

    override fun OnSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun OnError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }
}