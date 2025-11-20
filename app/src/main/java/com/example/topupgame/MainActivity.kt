package com.example.topupgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController // Import yang benar
import androidx.navigation.fragment.NavHostFragment // Import yang benar
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --- AWAL PERUBAHAN ---

        // 1. Dapatkan NavHostFragment terlebih dahulu
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // 2. Kemudian, dapatkan NavController dari NavHostFragment tersebut
        val navController = navHostFragment.navController

        // --- AKHIR PERUBAHAN ---

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setupWithNavController(navController)
    }
}
