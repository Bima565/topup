package com.example.topupgame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(R.layout.fragment_home_fg) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvGames: RecyclerView = view.findViewById(R.id.rvGames)
        rvGames.layoutManager = GridLayoutManager(requireContext(), 3)

        // Ambil 6 game pertama untuk ditampilkan di halaman utama
        val featuredGames = GameProvider.gameList.take(6)
        val adapter = GameAdapter(featuredGames)
        rvGames.adapter = adapter

        val tvSeeAllGame: TextView = view.findViewById(R.id.tvSeeAllGame)
        tvSeeAllGame.setOnClickListener {
            val intent = Intent(requireActivity(), pilih_game::class.java)
            startActivity(intent)
        }
    }
}
