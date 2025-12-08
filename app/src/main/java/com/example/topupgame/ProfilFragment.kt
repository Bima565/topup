package com.example.topupgame

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfilFragment : Fragment(R.layout.fragment_profil_fg) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve username from SharedPreferences
        val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val username = sharedPref.getString("USERNAME", "Bima1234") // Default value if not found

        // Display username
        val tvUsername: TextView = view.findViewById(R.id.tvUsername)
        tvUsername.text = username

        // Rekomendasi Produk Click (Welkin Moon)
        val cardRekomendasi: View = view.findViewById(R.id.cardRekomendasi)
        cardRekomendasi.setOnClickListener {
            // Find Genshin Impact game object to pass to TopUp activity
            val genshinGame = GameProvider.gameList.find { it.name == "Genshin Impact" }
            if (genshinGame != null) {
                val intent = Intent(requireContext(), top_up::class.java)
                intent.putExtra("GAME_NAME", genshinGame.name)
                intent.putExtra("GAME_ICON", genshinGame.icon)
                startActivity(intent)
            }
        }

        // Tentang Kami Expandable Sections
        setupExpandableSection(view, R.id.headerTentangAplikasi, R.id.arrowTentangAplikasi, R.id.descTentangAplikasi)
        setupExpandableSection(view, R.id.headerKontakKami, R.id.arrowKontakKami, R.id.descKontakKami)
        setupExpandableSection(view, R.id.headerAturan, R.id.arrowAturan, R.id.descAturan)
        setupExpandableSection(view, R.id.headerPrivasi, R.id.arrowPrivasi, R.id.descPrivasi)
    }

    private fun setupExpandableSection(view: View, headerId: Int, arrowId: Int, descId: Int) {
        val headerLayout: View = view.findViewById(headerId)
        val arrowText: TextView = view.findViewById(arrowId)
        val descText: TextView = view.findViewById(descId)

        headerLayout.setOnClickListener {
            if (descText.visibility == View.VISIBLE) {
                descText.visibility = View.GONE
                arrowText.rotation = 0f
            } else {
                descText.visibility = View.VISIBLE
                arrowText.rotation = 90f
            }
        }
    }
}
