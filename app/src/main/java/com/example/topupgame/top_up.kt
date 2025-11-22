package com.example.topupgame

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class top_up : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_top_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrieve data from Intent
        val gameName = intent.getStringExtra("GAME_NAME") ?: "Unknown Game"
        val gameIcon = intent.getIntExtra("GAME_ICON", R.drawable.ic_game_genshin)

        // Update UI with game details
        val tvGameName: TextView = findViewById(R.id.tvGameNameDetail)
        val ivGameIcon: ImageView = findViewById(R.id.ivGameIconDetail)
        
        tvGameName.text = gameName
        ivGameIcon.setImageResource(gameIcon)

        // Setup RecyclerView
        val rvProducts: RecyclerView = findViewById(R.id.rvProducts)
        rvProducts.layoutManager = GridLayoutManager(this, 3) // 2 columns grid
        
        // Load products based on the game name
        val productList = GameProvider.getProductsForGame(gameName)
        
        val productAdapter = ProductAdapter(productList)
        rvProducts.adapter = productAdapter

        // Back button
        val btnBack: ImageView = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
        
        // Add to cart button (Logic can be added later)
        // val btnAddToCart: Button = findViewById(R.id.btnAddToCart)
    }
}
