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

    // List produk Google Play
    val productGooglePlay = listOf(
        Product("IDR 20.000", "Rp.22.000", R.drawable.ic_voucher_google_play),
        Product("IDR 50.000", "Rp.55.000", R.drawable.ic_voucher_google_play),
        Product("IDR 100.000", "Rp.110.000", R.drawable.ic_voucher_google_play),
        Product("IDR 150.000", "Rp.165.000", R.drawable.ic_voucher_google_play),
        Product("IDR 300.000", "Rp.330.000", R.drawable.ic_voucher_google_play),
        Product("IDR 500.000", "Rp.550.000", R.drawable.ic_voucher_google_play)
    )

    // List produk Steam Wallet
    val productSteam = listOf(
        Product("IDR 12.000", "Rp.14.000", R.drawable.ic_voucher_steam),
        Product("IDR 45.000", "Rp.50.000", R.drawable.ic_voucher_steam),
        Product("IDR 60.000", "Rp.66.000", R.drawable.ic_voucher_steam),
        Product("IDR 90.000", "Rp.99.000", R.drawable.ic_voucher_steam),
        Product("IDR 120.000", "Rp.132.000", R.drawable.ic_voucher_steam),
        Product("IDR 250.000", "Rp.275.000", R.drawable.ic_voucher_steam),
        Product("IDR 400.000", "Rp.440.000", R.drawable.ic_voucher_steam),
        Product("IDR 600.000", "Rp.660.000", R.drawable.ic_voucher_steam)
    )

    // List produk Razer Gold
    val productRazer = listOf(
        Product("IDR 10.000", "Rp.11.000", R.drawable.ic_voucher_razer_gold),
        Product("IDR 20.000", "Rp.22.000", R.drawable.ic_voucher_razer_gold),
        Product("IDR 50.000", "Rp.55.000", R.drawable.ic_voucher_razer_gold),
        Product("IDR 100.000", "Rp.110.000", R.drawable.ic_voucher_razer_gold),
        Product("IDR 200.000", "Rp.220.000", R.drawable.ic_voucher_razer_gold),
        Product("IDR 500.000", "Rp.550.000", R.drawable.ic_voucher_razer_gold),
        Product("IDR 1.000.000", "Rp.1.100.000", R.drawable.ic_voucher_razer_gold)
    )

    // List produk Playstation Network
    val productPSN = listOf(
        Product("IDR 100.000", "Rp.110.000", R.drawable.ic_voucher_playstation),
        Product("IDR 200.000", "Rp.220.000", R.drawable.ic_voucher_playstation),
        Product("IDR 400.000", "Rp.440.000", R.drawable.ic_voucher_playstation),
        Product("IDR 600.000", "Rp.660.000", R.drawable.ic_voucher_playstation),
        Product("IDR 1.000.000", "Rp.1.100.000", R.drawable.ic_voucher_playstation)
    )

    // List produk Xbox
    val productXbox = listOf(
        Product("USD 5", "Rp.80.000", R.drawable.ic_voucher_xbox),
        Product("USD 10", "Rp.160.000", R.drawable.ic_voucher_xbox),
        Product("USD 15", "Rp.240.000", R.drawable.ic_voucher_xbox),
        Product("USD 20", "Rp.320.000", R.drawable.ic_voucher_xbox),
        Product("USD 25", "Rp.400.000", R.drawable.ic_voucher_xbox),
        Product("USD 50", "Rp.800.000", R.drawable.ic_voucher_xbox)
    )

    // List produk Nintendo
    val productNintendo = listOf(
        Product("USD 10", "Rp.160.000", R.drawable.ic_voucher_nintendo),
        Product("USD 20", "Rp.320.000", R.drawable.ic_voucher_nintendo),
        Product("USD 35", "Rp.560.000", R.drawable.ic_voucher_nintendo),
        Product("USD 50", "Rp.800.000", R.drawable.ic_voucher_nintendo)
    )

    fun getProductsForVoucher(voucherName: String): List<Product> {
        return when (voucherName) {
            "Google Play Gift Card" -> productGooglePlay
            "Steam Wallet" -> productSteam
            "Razer Gold" -> productRazer
            "Playstation Network" -> productPSN
            "Xbox Gift Card" -> productXbox
            "Nintendo Switch eShop" -> productNintendo
            else -> emptyList()
        }
    }
}
