package com.example.topupgame

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
        val adapter = GameAdapter(GameProvider.gameList)
        rvGames.adapter = adapter
    }
}
