package com.example.recyclerview_menucontexto.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclerview_menucontexto.commons.Result
import com.example.recyclerview_menucontexto.domain.model.Product
import com.example.recyclerview_menucontexto.domain.usecase.AddProductsUseCase
import com.example.recyclerview_menucontexto.domain.usecase.DeleteProductUseCase
import com.example.recyclerview_menucontexto.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val addProductsUseCase: AddProductsUseCase,
    private val deleteProductUseCase: DeleteProductUseCase
) :
    ViewModel() {

    private val _products = MutableLiveData<Result<List<Product>>>()
    val products: LiveData<Result<List<Product>>> = _products
    fun getProducts() = viewModelScope.launch {
        _products.postValue(Result.Loading)

        try {
            val products = getProductsUseCase()

            _products.postValue(Result.Success(products))
        } catch (e: Exception) {
            _products.postValue(Result.Error(exception = e))
        }
    }

    fun addProduct(product: Product) = viewModelScope.launch {
        addProductsUseCase(product)
    }

    fun deleteProduct(name: String) = viewModelScope.launch {
        deleteProductUseCase(name)
        getProducts()
    }
}