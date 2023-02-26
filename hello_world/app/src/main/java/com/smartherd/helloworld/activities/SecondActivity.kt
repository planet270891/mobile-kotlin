package com.smartherd.helloworld.activities

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.helloworld.Constants
import com.smartherd.helloworld.R
import com.smartherd.helloworld.showToast


class SecondActivity : AppCompatActivity() {

    companion object{
        val TAG: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        val txvUserMessage = findViewById<TextView>(R.id.txvUserMessage)

        bundle?.let{
            val msg = bundle.getString(Constants.USER_MSG_KEY)
            if (msg != null) {
                showToast(msg)
                txvUserMessage.text = msg
            }
        }


    }



}