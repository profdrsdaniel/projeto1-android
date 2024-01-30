package com.example.recyclerview_menucontexto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(
    private val items: MutableList<Product>,
    private val goToDetail: (item: Product) -> Unit
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.context = parent.context

        //Layout inflater é responsável por transformar o XML em uma classe onde podemos acessar os
        //atributos dessa classe.
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_product_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.rootView.setOnLongClickListener {
            showPopupMenu(it, position)
            true
        }

        holder.itemView.setOnClickListener {
            goToDetail(items[position])
        }

        Glide.with(holder.itemView.context).load(items[position].urlImage).centerCrop()
            .into(holder.imageProduct)

        holder.nameProduct.text = items[position].name
        holder.priceProduct.text = items[position].price

    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageProduct: ImageView = itemView.findViewById(R.id.imgProduct)
        val nameProduct: TextView = itemView.findViewById(R.id.tvProductName)
        val priceProduct: TextView = itemView.findViewById(R.id.tvProductPrice)
    }

    private fun showPopupMenu(view: View, position: Int) {
        PopupMenu(context, view).apply {
            setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.context_menu_item_remove -> {
                        removeItem(items[position])
                        true
                    }

                    else -> false
                }
            }
            inflate(R.menu.context_menu)
            show()
        }
    }

    fun removeItem(product: Product) {
        this.items.remove(product)
        notifyDataSetChanged()
    }
}