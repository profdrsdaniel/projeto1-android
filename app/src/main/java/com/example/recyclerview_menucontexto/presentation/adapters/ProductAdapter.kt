package com.example.recyclerview_menucontexto.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_menucontexto.domain.model.Product
import com.example.recyclerview_menucontexto.R
import com.example.recyclerview_menucontexto.databinding.ListProductItemBinding

class ProductAdapter(
    private val items: MutableList<Product>,
    private val goToDetail: (item: Product) -> Unit
) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.context = parent.context

        val binding =
            ListProductItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(items[position]) {
            holder.bind(this)
        }
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ListProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.product = product

            binding.root.setOnLongClickListener {
                showPopupMenu(it, product)
                true
            }

            binding.root.setOnClickListener {
                goToDetail(product)
            }
        }
    }

    fun showPopupMenu(view: View, product: Product) {
        PopupMenu(context, view).apply {
            setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.context_menu_item_remove -> {
                        removeItem(product)
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