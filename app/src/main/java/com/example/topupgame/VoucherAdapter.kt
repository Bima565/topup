package com.example.topupgame

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VoucherAdapter(private val voucherList: List<Voucher>) :
    RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>() {

    class VoucherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val voucherIcon: ImageView = itemView.findViewById(R.id.ivVoucherIcon)
        val voucherName: TextView = itemView.findViewById(R.id.tvVoucherName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoucherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_voucher, parent, false)
        return VoucherViewHolder(view)
    }

    override fun onBindViewHolder(holder: VoucherViewHolder, position: Int) {
        val voucher = voucherList[position]
        holder.voucherIcon.setImageResource(voucher.icon)
        holder.voucherName.text = voucher.name
    }

    override fun getItemCount() = voucherList.size
}
