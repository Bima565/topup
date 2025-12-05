package com.example.topupgame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TransaksiAdapter(private var transaksiList: List<Transaksi>) :
    RecyclerView.Adapter<TransaksiAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProductImage: ImageView = itemView.findViewById(R.id.ivProductImage)
        val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
        val tvProductPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val tvStoreName: TextView = itemView.findViewById(R.id.tvStoreName)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaksi, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaksi = transaksiList[position]
        val product = transaksi.product

        holder.ivProductImage.setImageResource(product.image)
        holder.tvProductName.text = product.name
        holder.tvProductPrice.text = product.price
        holder.tvStoreName.text = product.storeName
        holder.tvStatus.text = transaksi.status
    }

    override fun getItemCount() = transaksiList.size

    fun updateList(newList: List<Transaksi>) {
        transaksiList = newList
        notifyDataSetChanged()
    }
}