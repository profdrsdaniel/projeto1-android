package com.example.recyclerview_menucontexto.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recyclerview_menucontexto.domain.usecase.GetProductsUseCase

class ProductViewModel(private val getProductsUseCase: GetProductsUseCase = GetProductsUseCase()) :
    ViewModel() {

    fun getProducts() = getProductsUseCase.invoke()
}