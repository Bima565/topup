package com.example.topupgame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class top_up : AppCompatActivity(), ProductAdapter.OnItemClickListener {

    private var selectedProduct: Product? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_top_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gameName = intent.getStringExtra("GAME_NAME") ?: "Unknown Game"
        val gameIcon = intent.getIntExtra("GAME_ICON", R.drawable.ic_game_genshin)

        val tvGameName: TextView = findViewById(R.id.tvGameNameDetail)
        val ivGameIcon: ImageView = findViewById(R.id.ivGameIconDetail)
        
        tvGameName.text = gameName
        ivGameIcon.setImageResource(gameIcon)

        val rvProducts: RecyclerView = findViewById(R.id.rvProducts)
        rvProducts.layoutManager = GridLayoutManager(this, 2)
        
        var productList = GameProvider.getProductsForGame(gameName)
        if (productList.isEmpty()) {
            productList = VoucherProvider.getProductsForVoucher(gameName)
        }
        
        val productAdapter = ProductAdapter(productList, this)
        rvProducts.adapter = productAdapter

        val btnBack: ImageView = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
        
        val btnAddToCart: Button = findViewById(R.id.btnAddToCart)
        btnAddToCart.setOnClickListener {
            if (selectedProduct != null) {
                val intent = Intent(this, Keranjang::class.java)
                intent.putExtra("SELECTED_PRODUCT", selectedProduct)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Pilih produk terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }

        val spStoreName: Spinner = findViewById(R.id.spStoreName)
        val storeList = listOf("DntStore", "PhoenixGame", "NalShop", "HHStore", "InsiderStore")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, storeList)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spStoreName.adapter = spinnerAdapter

        spStoreName.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedStore = storeList[position]
                productList.forEach { it.storeName = selectedStore }
                productAdapter.notifyDataSetChanged() 
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    override fun onItemClick(product: Product) {
        selectedProduct = product
    }
}
