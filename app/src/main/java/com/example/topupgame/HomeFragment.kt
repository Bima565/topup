package com.example.topupgame

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2

class HomeFragment : Fragment(R.layout.fragment_home_fg) {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_fg, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Game RecyclerView
        val rvGames: RecyclerView = view.findViewById(R.id.rvGames)
        rvGames.layoutManager = GridLayoutManager(requireContext(), 3)
        val featuredGames = GameProvider.gameList.take(6)
        val gameAdapter = GameAdapter(featuredGames) { game ->
            // Navigate to top_up activity
            val intent = Intent(requireContext(), top_up::class.java)
            intent.putExtra("GAME_NAME", game.name)
            intent.putExtra("GAME_ICON", game.icon)
            startActivity(intent)
        }
        rvGames.adapter = gameAdapter

        val tvSeeAllGame: TextView = view.findViewById(R.id.lihatSemuaGame) // ID diperbaiki di sini
        tvSeeAllGame.setOnClickListener {
            val intent = Intent(requireActivity(), pilih_game::class.java)
            startActivity(intent)
        }

        // Voucher RecyclerView
        val rvVoucher: RecyclerView = view.findViewById(R.id.rvVoucher)
        rvVoucher.layoutManager = GridLayoutManager(requireContext(), 3)
        val voucherAdapter = VoucherAdapter(VoucherProvider.voucherList) { voucher ->
            // Navigate to top_up activity (reused for vouchers too)
            val intent = Intent(requireContext(), top_up::class.java)
            intent.putExtra("GAME_NAME", voucher.name)
            intent.putExtra("GAME_ICON", voucher.icon)
            startActivity(intent)
        }
        rvVoucher.adapter = voucherAdapter

        val tvSeeAllVoucher: TextView = view.findViewById(R.id.lihatSemuaVoucher)
        tvSeeAllVoucher.setOnClickListener {
            val intent = Intent(requireActivity(), PilihVoucher::class.java)
            startActivity(intent)
        }


        val bannerImages = listOf(
            R.drawable.banner_1,
            R.drawable.banner_2,
            R.drawable.banner_3
        )

        val viewPager: ViewPager2 = view.findViewById(R.id.bannerViewPager)

        // 1. Siapkan data gambar banner Anda (dari drawable)
        val adapter = BannerAdapter(bannerImages)
        viewPager.adapter = adapter

        // --- AWAL KODE TAMBAHAN UNTUK EFEK SLIDER ---

        // Nonaktifkan clipping agar item di luar batas bisa terlihat (untuk efek peek)
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3 // Muat lebih banyak halaman untuk kelancaran

        // Atur padding untuk ViewPager2 agar item sebelumnya dan berikutnya terlihat sebagian
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.page_margin)
        val peekOffsetPx = resources.getDimensionPixelOffset(R.dimen.peek_offset)
        viewPager.setPadding(peekOffsetPx, 0, peekOffsetPx, 0)

        // Atur margin antar halaman
        val pageTransformer = MarginPageTransformer(pageMarginPx)
        viewPager.setPageTransformer(pageTransformer)

        // --- AKHIR KODE TAMBAHAN ---
    }

}
