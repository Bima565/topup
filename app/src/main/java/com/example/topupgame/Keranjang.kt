package com.example.topupgame

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class Keranjang : AppCompatActivity() {

    companion object {
        val cartItems = mutableListOf<Product>()
    }

    private lateinit var rvCartItems: RecyclerView
    private lateinit var adapter: KeranjangAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_keranjang)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvCartItems = findViewById(R.id.rvCartItems)
        rvCartItems.layoutManager = LinearLayoutManager(this)
        adapter = KeranjangAdapter(cartItems)
        rvCartItems.adapter = adapter

        val selectedProduct = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("SELECTED_PRODUCT", Product::class.java)
        } else {
            intent.getParcelableExtra<Product>("SELECTED_PRODUCT")
        }

        if (selectedProduct != null) {
             if (!cartItems.any { it.name == selectedProduct.name }) {
                cartItems.add(selectedProduct)
                adapter.notifyItemInserted(cartItems.size - 1)
            }
        }

        val btnBack: ImageView = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        val btnCheckout: Button = findViewById(R.id.btnCheckout)
        btnCheckout.setOnClickListener {
            val selectedItems = adapter.getSelectedItems()
            if (selectedItems.isEmpty()) {
                Toast.makeText(this, "Pilih setidaknya satu item untuk checkout.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MetodePembayaran::class.java)
                intent.putParcelableArrayListExtra("SELECTED_ITEMS", ArrayList(selectedItems))
                startActivity(intent)
            }
        }
    }
}