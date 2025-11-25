package com.example.topupgame

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritFragment : Fragment(R.layout.fragment_favorit_fg), ProductAdapter.OnItemClickListener {

    private lateinit var rvFavorites: RecyclerView
    private lateinit var adapter: ProductAdapter
    private val favoriteProducts = mutableListOf<Product>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvFavorites = view.findViewById(R.id.rvFavorites)
        rvFavorites.layoutManager = GridLayoutManager(requireContext(), 2)
        
        adapter = ProductAdapter(favoriteProducts, this)
        rvFavorites.adapter = adapter
    }

    private fun refreshFavoriteList() {
        favoriteProducts.clear()
        
        val allGameProducts = listOf(
            GameProvider.productGenshin,
            GameProvider.productHonkai,
            GameProvider.productZZZ,
            GameProvider.productML,
            GameProvider.productValorant,
            GameProvider.productPUBG
        ).flatten()
        
        favoriteProducts.addAll(allGameProducts.filter { it.isFavorite })

        val allVoucherProducts = listOf(
            VoucherProvider.productGooglePlay,
            VoucherProvider.productSteam,
            VoucherProvider.productRazer,
            VoucherProvider.productPSN,
            VoucherProvider.productXbox,
            VoucherProvider.productNintendo
        ).flatten()

        favoriteProducts.addAll(allVoucherProducts.filter { it.isFavorite })
        
        if(::adapter.isInitialized) {
            adapter.notifyDataSetChanged()
        }
    }

    override fun onItemClick(product: Product) {
        val parentGame = GameProvider.gameList.find { game ->
            GameProvider.getProductsForGame(game.name).contains(product)
        }

        if (parentGame != null) {
            val intent = Intent(requireContext(), top_up::class.java).apply {
                putExtra("GAME_NAME", parentGame.name)
                putExtra("GAME_ICON", parentGame.icon)
            }
            startActivity(intent)
            return
        }

        val parentVoucher = VoucherProvider.voucherList.find { voucher ->
            VoucherProvider.getProductsForVoucher(voucher.name).contains(product)
        }

        if (parentVoucher != null) {
            val intent = Intent(requireContext(), top_up::class.java).apply {
                putExtra("GAME_NAME", parentVoucher.name)
                putExtra("GAME_ICON", parentVoucher.icon)
            }
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        refreshFavoriteList()
    }
}
