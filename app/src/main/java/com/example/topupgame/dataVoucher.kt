package com.example.topupgame

import androidx.annotation.DrawableRes

// Data class untuk merepresentasikan satu item voucher
data class Voucher(
    val name: String,
    @DrawableRes val icon: Int
)

// Object untuk menyediakan daftar voucher statis
object VoucherProvider {
    val voucherList = listOf(
        Voucher("Google Play Gift Card", R.drawable.ic_voucher_google_play),
        Voucher("Steam Wallet", R.drawable.ic_voucher_steam),
        Voucher("Razer Gold", R.drawable.ic_voucher_razer_gold),
        Voucher("Playstation Network", R.drawable.ic_voucher_playstation),
        Voucher("Xbox Gift Card", R.drawable.ic_voucher_xbox),
        Voucher("Nintendo Switch eShop", R.drawable.ic_voucher_nintendo)
    )
}
