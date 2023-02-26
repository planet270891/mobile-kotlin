package com.sandy.latihan

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SuhuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.suhu_activity)

        val txtCelclius = findViewById<EditText>(R.id.txtCelcius)
        val txtFahrenheit = findViewById<EditText>(R.id.txtFahrenheit)
        val txtReamur = findViewById<EditText>(R.id.txtReamur)
        val txtKelvin = findViewById<EditText>(R.id.txtKelvin)

        txtFahrenheit.setEnabled(false)
        txtReamur.setEnabled(false)
        txtKelvin.setEnabled(false)

        txtCelclius.transformationMethod = null
        txtFahrenheit.transformationMethod = null
        txtReamur.transformationMethod = null
        txtKelvin.transformationMethod = null

        txtCelclius.setText("0")
        txtFahrenheit.setText("0")
        txtReamur.setText("0")
        txtKelvin.setText("0")

        val btnKonvernsi = findViewById<Button>(R.id.btnKonversi)
        btnKonvernsi.setOnClickListener {
            if(txtCelclius.text.isNotEmpty()){
                val iCelclius: Double = txtCelclius.text.toString().toDouble()
                val celcius_to_fahrenheit = (1.8 * iCelclius) + 32
                val celcius_to_reamur = 1.25 * iCelclius
                val celcius_to_kelvin = iCelclius + 273
                txtFahrenheit.setText(celcius_to_fahrenheit.toString())
                txtReamur.setText(celcius_to_reamur.toString())
                txtKelvin.setText(celcius_to_kelvin.toString())
            }else{
                Toast.makeText(this, "Silahkan isi nilai celcius !! ", Toast.LENGTH_SHORT).show()
            }
        }

    }
}