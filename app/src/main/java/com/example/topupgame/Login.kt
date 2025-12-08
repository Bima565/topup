package com.example.topupgame

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnMask = findViewById<Button>(R.id.btnMasuk)
        val btnGoogle = findViewById<LinearLayout>(R.id.btnGoogle)
        val edtUsername = findViewById<EditText>(R.id.edtUsername)

        btnMask.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            if (username.isEmpty()) {
                Toast.makeText(this, "Username harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                // Simpan username ke SharedPreferences
                val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("USERNAME", username)
                    apply()
                }

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        btnGoogle.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
