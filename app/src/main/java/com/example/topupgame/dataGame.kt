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
    var isFavorite: Boolean = false
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
        Product("60 Genesis Crystal", "Rp.11.000", R.drawable.ic_genesis_crystal),
        Product("Welkin Moon 1X", "Rp.90.000", R.drawable.ic_welkin),
        Product("300 Genesis Crystal", "Rp.55.000", R.drawable.ic_genesis_crystal),
        Product("980 Genesis Crystal", "Rp.165.000", R.drawable.ic_genesis_crystal),
        Product("1980 Genesis Crystal", "Rp.329.000", R.drawable.ic_genesis_crystal),
        Product("3280 Genesis Crystal", "Rp.549.000", R.drawable.ic_genesis_crystal)
    )

    // Sample products data for Honkai Star Rail
    val productHonkai = listOf(
        Product("60 Oneiric Shard", "Rp.16.000", R.drawable.ic_stellar_jade),
        Product("Express Supply Pass", "Rp.90.000", R.drawable.ic_supply_pass),
        Product("300 Oneiric Shard", "Rp.79.000", R.drawable.ic_stellar_jade),
        Product("980 Oneiric Shard", "Rp.249.000", R.drawable.ic_stellar_jade),
        Product("1980 Oneiric Shard", "Rp.479.000", R.drawable.ic_stellar_jade),
        Product("3280 Oneiric Shard", "Rp.799.000", R.drawable.ic_stellar_jade)
    )

    // Sample products data for Zenless Zone Zero
    val productZZZ = listOf(
        Product("60 Monochrome", "Rp.16.000", R.drawable.ic_monochrome),
        Product("Inter-Knot Membership", "Rp.90.000", R.drawable.ic_interknot_membershipp),
        Product("300 Monochrome", "Rp.79.000", R.drawable.ic_monochrome),
        Product("980 Monochrome", "Rp.249.000", R.drawable.ic_monochrome),
        Product("1980 Monochrome", "Rp.479.000", R.drawable.ic_monochrome),
        Product("3280 Monochrome", "Rp.799.000", R.drawable.ic_monochrome)
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
