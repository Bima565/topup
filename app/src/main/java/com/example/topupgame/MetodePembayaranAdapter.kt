package com.example.topupgame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MetodePembayaranAdapter(private val selectedItems: List<Product>) :
    RecyclerView.Adapter<MetodePembayaranAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProductImage: ImageView = itemView.findViewById(R.id.ivProductImage)
        val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
        val tvProductPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val tvStoreName: TextView = itemView.findViewById(R.id.tvStoreName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pembayaran, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = selectedItems[position]
        holder.ivProductImage.setImageResource(product.image)
        holder.tvProductName.text = product.name
        holder.tvProductPrice.text = product.price
        holder.tvStoreName.text = product.storeName
    }

    override fun getItemCount() = selectedItems.size
}