package com.example.recyclerview_menucontexto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val productViewModel: ProductViewModel by viewModels()
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recyclerview
        val recycler = findViewById<RecyclerView>(R.id.rcListOfProducts)
        val items = productViewModel.getProducts()

        // :: É um operador que cria uma referencia para funções, assim podemos usar como no
        // exemplo abaixo.
        adapter = ProductAdapter(items, ::goToDetail)
        recycler.adapter = adapter
    }

    private fun goToDetail(item: Product) {
        Intent(this, DetailActivity::class.java).apply {
            putExtra("data", item)
            startActivity(this)
        }
    }
}