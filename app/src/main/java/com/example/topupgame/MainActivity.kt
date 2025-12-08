package com.example.topupgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController // Make it accessible

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setupWithNavController(navController)

        // Periksa apakah ada "pesan" untuk navigasi
        if (intent.getStringExtra("NAVIGATE_TO") == "TRANSAKSI_FRAGMENT") {
            navController.navigate(R.id.transaksiFragment)
        }
    }

    fun navigateToTransaksi() {
        // Check if current destination is already transaksiFragment to avoid re-navigation
        if (navController.currentDestination?.id != R.id.transaksiFragment) {
            navController.navigate(R.id.transaksiFragment)
        }
    }
}
