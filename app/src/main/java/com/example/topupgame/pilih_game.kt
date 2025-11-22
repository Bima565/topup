package com.example.topupgame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class pilih_game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilih_game)

        val rvGames: RecyclerView = findViewById(R.id.rvGames)
        rvGames.layoutManager = GridLayoutManager(this, 3)
        val adapter = GameAdapter(GameProvider.gameList) { game ->
            val intent = Intent(this, top_up::class.java)
            intent.putExtra("GAME_NAME", game.name)
            intent.putExtra("GAME_ICON", game.icon)
            startActivity(intent)
        }
        rvGames.adapter = adapter
    }
}
