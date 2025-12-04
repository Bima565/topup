package com.example.topupgame

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MetodePembayaran : AppCompatActivity() {

    private lateinit var rvSelectedItems: RecyclerView
    private lateinit var adapter: MetodePembayaranAdapter
    private lateinit var tvTotalPesanan: TextView
    private lateinit var tvBiayaAdmin: TextView
    private lateinit var tvTotalPembayaran: TextView
    private lateinit var tvFinalTotal: TextView
    private lateinit var tvPaymentMethod: TextView
    private lateinit var btnOVO: ImageButton
    private lateinit var btnDana: ImageButton
    private lateinit var btnGopay: ImageButton
    private lateinit var btnBayar: Button
    private lateinit var btnBack: ImageView

    private var totalPesanan = 0.0
    private val biayaAdmin = 62.0
    private var selectedItems = listOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metode_pembayaran)

        rvSelectedItems = findViewById(R.id.rvSelectedItems)
        tvTotalPesanan = findViewById(R.id.tvTotalPesanan)
        tvBiayaAdmin = findViewById(R.id.tvBiayaAdmin)
        tvTotalPembayaran = findViewById(R.id.tvTotalPembayaran)
        tvFinalTotal = findViewById(R.id.tvFinalTotal)
        tvPaymentMethod = findViewById(R.id.tvPaymentMethod)
        btnOVO = findViewById(R.id.btnOVO)
        btnDana = findViewById(R.id.btnDana)
        btnGopay = findViewById(R.id.btnGopay)
        btnBayar = findViewById(R.id.btnBayar)
        btnBack = findViewById(R.id.btnBack)

        selectedItems = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableArrayListExtra("SELECTED_ITEMS", Product::class.java) ?: emptyList()
        } else {
            intent.getParcelableArrayListExtra<Product>("SELECTED_ITEMS") ?: emptyList()
        }

        rvSelectedItems.layoutManager = LinearLayoutManager(this)
        adapter = MetodePembayaranAdapter(selectedItems)
        rvSelectedItems.adapter = adapter

        calculateTotal()
        updateTotalViews()

        btnOVO.setOnClickListener {
            tvPaymentMethod.text = "OVO"
            btnOVO.isSelected = true
            btnDana.isSelected = false
            btnGopay.isSelected = false
        }

        btnDana.setOnClickListener {
            tvPaymentMethod.text = "DANA"
            btnOVO.isSelected = false
            btnDana.isSelected = true
            btnGopay.isSelected = false
        }

        btnGopay.setOnClickListener {
            tvPaymentMethod.text = "gopay"
            btnOVO.isSelected = false
            btnDana.isSelected = false
            btnGopay.isSelected = true
        }

        btnBayar.setOnClickListener {
            if (tvPaymentMethod.text != "-") {
                Toast.makeText(this, "Pembayaran berhasil!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Pilih metode pembayaran terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun calculateTotal() {
        totalPesanan = selectedItems.sumOf { it.price.replace("Rp.", "").replace(".", "").toDouble() }
    }

    private fun updateTotalViews() {
        tvTotalPesanan.text = String.format("Rp.%,.0f", totalPesanan)
        tvBiayaAdmin.text = String.format("Rp.%,.0f", biayaAdmin)
        val totalPembayaran = totalPesanan + biayaAdmin
        tvTotalPembayaran.text = String.format("Rp.%,.0f", totalPembayaran)
        tvFinalTotal.text = String.format("Rp.%,.0f", totalPembayaran)
    }
}