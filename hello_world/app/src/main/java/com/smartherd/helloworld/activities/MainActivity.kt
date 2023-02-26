package com.smartherd.helloworld.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.smartherd.helloworld.Constants
import com.smartherd.helloworld.R
import com.smartherd.helloworld.showToast


class MainActivity : AppCompatActivity() {

    companion object{
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowToast = findViewById<Button>(R.id.btnShowToast)
        val btnSendMsgToNextActivity = findViewById<Button>(R.id.btnSendMsgToNextActivity)
        val etUserMessage = findViewById<EditText>(R.id.etUserMessage)
        val btnShareToOtherApps = findViewById<Button>(R.id.btnShareToOtherApps)
        val btnRecyclerViewDemo = findViewById<Button>(R.id.btnRecyclerViewDemo)

        btnShowToast.setOnClickListener{
            val btn_clicked: String = resources.getString(R.string.btn_was_clicked)
            Log.i(TAG, btn_clicked)
            showToast(btn_clicked)
        }

        btnSendMsgToNextActivity.setOnClickListener{
            val message: String = etUserMessage.text.toString()
            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, message)
            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener{
            val message: String = etUserMessage.text.toString()
            var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, resources.getString(R.string.select_app)))
        }

        btnRecyclerViewDemo.setOnClickListener{
            var intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

    }
}