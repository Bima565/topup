package com.example.topupgame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfilFragment : Fragment(R.layout.fragment_profil_fg) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set username (dummy data as requested, matching layout)
        // val tvUsername: TextView = view.findViewById(R.id.tvUsername)
        // tvUsername.text = "Bima1234" // Already set in XML

        // Rekomendasi Produk Click (Welkin Moon)
        // Note: ID in XML should be cardRekomendasi or similar wrapping the item
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

        // Transaksi Buttons
        val btnLihatSemuaTransaksi: TextView = view.findViewById(R.id.btnLihatSemuaTransaksi)
        val btnKeranjang: View = view.findViewById(R.id.btnKeranjang)
        val btnProses: View = view.findViewById(R.id.btnProses)
        val btnSelesai: View = view.findViewById(R.id.btnSelesai)

        val transactionClickListener = View.OnClickListener {
            // Navigate to TransaksiFragment via bottom navigation or direct switch if possible
            // Since this is a Fragment inside a host (likely MainActivity with BottomNav),
            // we should ideally use the NavController or communicate with Activity.
            // For now, assuming MainActivity handles navigation or we can't easily switch tabs programmatically
            // without knowing the ID of the bottom nav.
            // However, the prompt says "sama seperti fragment_transaksi_fg.xml kemudian nanti kalau diklik menuju ke situ"
            // If TransaksiFragment is one of the main tabs, we usually switch the ViewPager or BottomNav selection.
            
            // Checking MainActivity structure from previous interactions (it has BottomNavigationView usually)
            // Let's assume MainActivity has a public method or we can find the BottomNav.
            // A common way in simple apps:
            (activity as? MainActivity)?.navigateToTransaksi()
        }

        btnLihatSemuaTransaksi.setOnClickListener(transactionClickListener)
        btnKeranjang.setOnClickListener(transactionClickListener)
        btnProses.setOnClickListener(transactionClickListener)
        btnSelesai.setOnClickListener(transactionClickListener)


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
