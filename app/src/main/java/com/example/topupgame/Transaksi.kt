package com.example.topupgame

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Transaksi(
    val product: Product,
    var status: String
) : Parcelable

object TransaksiRepository {
    val riwayatTransaksi = mutableListOf<Transaksi>()
}