package com.sandy.latihan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class CalculatorActity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator_activity)

        val btnTambah = findViewById<Button>(R.id.btnTambah)
        val btnKurang = findViewById<Button>(R.id.btnKurang)
        val btnKali = findViewById<Button>(R.id.btnKali)
        val btnBagi = findViewById<Button>(R.id.btnBagi)
        val btnHome = findViewById<Button>(R.id.btnHome)
        val txtBilangan1 = findViewById<EditText>(R.id.txtBilangan1)
        val txtBilangan2 = findViewById<EditText>(R.id.txtBilangan2)
        val txtHasil = findViewById<EditText>(R.id.txtHasil)

        txtBilangan1.transformationMethod = null
        txtBilangan2.transformationMethod = null
        txtHasil.setEnabled(false)
        txtHasil.setText("0")

        btnHome.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnTambah.setOnClickListener{
            if(!txtBilangan1.text.isNotEmpty()){
                Toast.makeText(this, "Silahkan isi bilangan 1 ", Toast.LENGTH_SHORT).show()
            }else if(!txtBilangan2.text.isNotEmpty()){
                Toast.makeText(this, "Silahkan isi bilangan 2 ", Toast.LENGTH_SHORT).show()
            }else{
                val bil1: Double = txtBilangan1.text.toString().toDouble()
                val bil2: Double = txtBilangan2.text.toString().toDouble()
                val hasil: Double = this.Tambah(bil1, bil2)
                txtHasil.setText(hasil.toString())
            }
        }

        btnKurang.setOnClickListener{
            if(!txtBilangan1.text.isNotEmpty()){
                Toast.makeText(this, "Silahkan isi bilangan 1 ", Toast.LENGTH_SHORT).show()
            }else if(!txtBilangan2.text.isNotEmpty()){
                Toast.makeText(this, "Silahkan isi bilangan 2 ", Toast.LENGTH_SHORT).show()
            }else{
                val bil1: Double = txtBilangan1.text.toString().toDouble()
                val bil2: Double = txtBilangan2.text.toString().toDouble()
                val hasil: Double = this.Kurang(bil1, bil2)
                txtHasil.setText(hasil.toString())
            }
        }

        btnKali.setOnClickListener{
            if(!txtBilangan1.text.isNotEmpty()){
                Toast.makeText(this, "Silahkan isi bilangan 1 ", Toast.LENGTH_SHORT).show()
            }else if(!txtBilangan2.text.isNotEmpty()){
                Toast.makeText(this, "Silahkan isi bilangan 2 ", Toast.LENGTH_SHORT).show()
            }else{
                val bil1: Double = txtBilangan1.text.toString().toDouble()
                val bil2: Double = txtBilangan2.text.toString().toDouble()
                val hasil: Double = this.Kali(bil1, bil2)
                txtHasil.setText(hasil.toString())
            }
        }

        btnBagi.setOnClickListener{
            if(!txtBilangan1.text.isNotEmpty()){
                Toast.makeText(this, "Silahkan isi bilangan 1 ", Toast.LENGTH_SHORT).show()
            }else if(!txtBilangan2.text.isNotEmpty()){
                Toast.makeText(this, "Silahkan isi bilangan 2 ", Toast.LENGTH_SHORT).show()
            }else{
                val bil1: Double = txtBilangan1.text.toString().toDouble()
                val bil2: Double = txtBilangan2.text.toString().toDouble()
                val hasil: Double = this.Bagi(bil1, bil2)
                txtHasil.setText(hasil.toString())
            }
        }

    }

    fun Tambah(bil1: Double, bil2: Double): Double{
       return bil1 + bil2
    }

    fun Kurang(bil1: Double, bil2: Double): Double{
        return bil1 - bil2
    }

    fun Kali(bil1: Double, bil2: Double): Double{
        return bil1 * bil2
    }

    fun Bagi(bil1: Double, bil2: Double): Double{
        if(bil2 > 0){
            return bil1 / bil2
        }else{
            return 0.0
        }
    }

}