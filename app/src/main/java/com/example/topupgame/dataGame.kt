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

    // Sample products data
    val productList = listOf(
        Product("60 Genesis Crystal", "Rp.11.000", R.drawable.ic_genesis_crystal), // Placeholder image
        Product("Welkin Moon 1X", "Rp.90.000", R.drawable.ic_welkin),   // Placeholder image
        Product("300 Genesis Crystal", "Rp.55.000", R.drawable.ic_genesis_crystal),
        Product("980 Genesis Crystal", "Rp.165.000", R.drawable.ic_genesis_crystal)
    )
}
