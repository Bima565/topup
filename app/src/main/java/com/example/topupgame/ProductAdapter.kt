package com.example.topupgame

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    private val productList: List<Product>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION

    interface OnItemClickListener {
        fun onItemClick(product: Product)
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivFavorite: ImageView = itemView.findViewById(R.id.ivFavorite)
        val ivProductImage: ImageView = itemView.findViewById(R.id.ivProductImage)
        val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
        val tvProductPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val tvStoreName: TextView = itemView.findViewById(R.id.tvStoreName)
        val productContainer: ConstraintLayout = itemView.findViewById(R.id.productContainer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.tvProductName.text = product.name
        holder.tvProductPrice.text = product.price
        holder.ivProductImage.setImageResource(product.image)

        if (!product.storeName.isNullOrEmpty()) {
            holder.tvStoreName.text = product.storeName
            holder.tvStoreName.visibility = View.VISIBLE
        } else {
            holder.tvStoreName.visibility = View.GONE
        }

        holder.productContainer.isSelected = selectedPosition == position

        holder.productContainer.setOnClickListener {
            val previousSelectedPosition = selectedPosition
            selectedPosition = holder.adapterPosition
            notifyItemChanged(previousSelectedPosition)
            notifyItemChanged(selectedPosition)
            listener.onItemClick(product)
        }

        updateFavoriteIcon(holder.ivFavorite, product.isFavorite)
        holder.ivFavorite.setOnClickListener {
            product.isFavorite = !product.isFavorite
            updateFavoriteIcon(holder.ivFavorite, product.isFavorite)
        }
    }

    private fun updateFavoriteIcon(imageView: ImageView, isFavorite: Boolean) {
        if (isFavorite) {
            imageView.setImageResource(R.drawable.ic_favorite)
            imageView.setColorFilter(Color.RED)
        } else {
            imageView.setImageResource(R.drawable.ic_favorite)
            imageView.setColorFilter(Color.BLACK)
        }
    }

    override fun getItemCount() = productList.size
}