package com.example.topupgame

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritFragment : Fragment(R.layout.fragment_favorit_fg) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvFavorites: RecyclerView = view.findViewById(R.id.rvFavorites)
        rvFavorites.layoutManager = GridLayoutManager(requireContext(), 2)
        
        // Gather all favorite products from both GameProvider and VoucherProvider
        val favoriteProducts = mutableListOf<Product>()
        
        // Check GameProvider lists
        // Note: This is a simple aggregation. In a real app with a database, you'd query the DB.
        // Since we are using static lists, we need to iterate through them.
        // For simplicity in this prototype, I'll iterate through the known lists.
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

        val adapter = ProductAdapter(favoriteProducts)
        rvFavorites.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        // Refresh the list when returning to the fragment
        view?.let { onViewCreated(it, Bundle()) }
    }
}
