package com.example.topupgame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KeranjangAdapter(private val cartItems: List<Product>) :
    RecyclerView.Adapter<KeranjangAdapter.KeranjangViewHolder>() {

    class KeranjangViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProductImage: ImageView = itemView.findViewById(R.id.ivProductImage)
        val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
        val tvProductPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val tvStoreName: TextView = itemView.findViewById(R.id.tvStoreName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeranjangViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_keranjang, parent, false)
        return KeranjangViewHolder(view)
    }

    override fun onBindViewHolder(holder: KeranjangViewHolder, position: Int) {
        val product = cartItems[position]
        holder.ivProductImage.setImageResource(product.image)
        holder.tvProductName.text = product.name
        holder.tvProductPrice.text = product.price
        holder.tvStoreName.text = product.storeName
    }

    override fun getItemCount() = cartItems.size
}