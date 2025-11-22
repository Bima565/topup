package com.example.topupgame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PilihVoucher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_voucher)

        val rvVoucher: RecyclerView = findViewById(R.id.rvVoucherAll)
        rvVoucher.layoutManager = GridLayoutManager(this, 3)
        val adapter = VoucherAdapter(VoucherProvider.voucherList) { voucher ->
            val intent = Intent(this, top_up::class.java)
            intent.putExtra("GAME_NAME", voucher.name)
            intent.putExtra("GAME_ICON", voucher.icon)
            startActivity(intent)
        }
        rvVoucher.adapter = adapter
    }
}
