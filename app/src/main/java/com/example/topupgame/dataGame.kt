package com.example.topupgame

import androidx.annotation.DrawableRes

// Data class untuk merepresentasikan satu item game
data class Game(
    val name: String,
    @DrawableRes val icon: Int // Gunakan @DrawableRes untuk memastikan ID drawable yang valid
)

// Data class untuk item produk (top up)
data class Product(
    val name: String,
    val price: String,
    @DrawableRes val image: Int,
    var isFavorite: Boolean = false,
    var storeName: String? = null
)

// Object untuk menyediakan daftar game statis
object GameProvider {
    val gameList = listOf(
        Game("Genshin Impact", R.drawable.ic_game_genshin),
        Game("Honkai Star Rails", R.drawable.ic_game_hsr),
        Game("Zenless Zone Zero", R.drawable.ic_game_zzz),
        Game("Mobile Legends", R.drawable.ic_game_ml),
        Game("Valorant", R.drawable.ic_game_valorant),
        Game("PUBG Mobile", R.drawable.ic_game_pubg)
    )

    // Sample products data for Genshin Impact
    val productGenshin = listOf(
        Product("60 Genesis Crystal", "Rp.11.000", R.drawable.ic_game_genshin),
        Product("Welkin Moon 1X", "Rp.90.000", R.drawable.ic_game_genshin),
        Product("300 Genesis Crystal", "Rp.55.000", R.drawable.ic_game_genshin),
        Product("980 Genesis Crystal", "Rp.165.000", R.drawable.ic_game_genshin),
        Product("1980 Genesis Crystal", "Rp.329.000", R.drawable.ic_game_genshin),
        Product("3280 Genesis Crystal", "Rp.549.000", R.drawable.ic_game_genshin)
    )

    // Sample products data for Honkai Star Rail
    val productHonkai = listOf(
        Product("60 Oneiric Shard", "Rp.16.000", R.drawable.ic_game_hsr),
        Product("Express Supply Pass", "Rp.90.000", R.drawable.ic_game_hsr),
        Product("300 Oneiric Shard", "Rp.79.000", R.drawable.ic_game_hsr),
        Product("980 Oneiric Shard", "Rp.249.000", R.drawable.ic_game_hsr),
        Product("1980 Oneiric Shard", "Rp.479.000", R.drawable.ic_game_hsr),
        Product("3280 Oneiric Shard", "Rp.799.000", R.drawable.ic_game_hsr)
    )

    // Sample products data for Zenless Zone Zero
    val productZZZ = listOf(
        Product("60 Monochrome", "Rp.16.000", R.drawable.ic_game_zzz),
        Product("Inter-Knot Membership", "Rp.90.000", R.drawable.ic_game_zzz),
        Product("300 Monochrome", "Rp.79.000", R.drawable.ic_game_zzz),
        Product("980 Monochrome", "Rp.249.000", R.drawable.ic_game_zzz),
        Product("1980 Monochrome", "Rp.479.000", R.drawable.ic_game_zzz),
        Product("3280 Monochrome", "Rp.799.000", R.drawable.ic_game_zzz)
    )

    // Sample products data for Mobile Legends
    val productML = listOf(
        Product("11 Diamonds", "Rp.3.500", R.drawable.ic_game_ml),
        Product("50 Diamonds", "Rp.15.000", R.drawable.ic_game_ml),
        Product("Weekly Diamond Pass", "Rp.28.000", R.drawable.ic_game_ml),
        Product("250 Diamonds", "Rp.80.000", R.drawable.ic_game_ml),
        Product("500 Diamonds", "Rp.150.000", R.drawable.ic_game_ml),
        Product("1000 Diamonds", "Rp.290.000", R.drawable.ic_game_ml)
    )

    // Sample products data for Valorant
    val productValorant = listOf(
        Product("125 VP", "Rp.15.000", R.drawable.ic_game_valorant),
        Product("420 VP", "Rp.50.000", R.drawable.ic_game_valorant),
        Product("700 VP", "Rp.80.000", R.drawable.ic_game_valorant),
        Product("1375 VP", "Rp.150.000", R.drawable.ic_game_valorant),
        Product("2400 VP", "Rp.250.000", R.drawable.ic_game_valorant),
        Product("4000 VP", "Rp.400.000", R.drawable.ic_game_valorant)
    )

    // Sample products data for PUBG Mobile
    val productPUBG = listOf(
        Product("60 UC", "Rp.14.000", R.drawable.ic_game_pubg),
        Product("325 UC", "Rp.70.000", R.drawable.ic_game_pubg),
        Product("660 UC", "Rp.140.000", R.drawable.ic_game_pubg),
        Product("1800 UC", "Rp.350.000", R.drawable.ic_game_pubg),
        Product("3850 UC", "Rp.700.000", R.drawable.ic_game_pubg),
        Product("8100 UC", "Rp.1.400.000", R.drawable.ic_game_pubg)
    )

    fun getProductsForGame(gameName: String): List<Product> {
        return when (gameName) {
            "Genshin Impact" -> productGenshin
            "Honkai Star Rails" -> productHonkai
            "Zenless Zone Zero" -> productZZZ
            "Mobile Legends" -> productML
            "Valorant" -> productValorant
            "PUBG Mobile" -> productPUBG
            else -> emptyList()
        }
    }
}
