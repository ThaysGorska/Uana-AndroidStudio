package com.example.uana.api

import com.example.uana.model.Categoria
import com.example.uana.model.Produto
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listCategoria()
    }

    suspend fun addProduto(produto: Produto): Response<Produto> {
        return RetrofitInstance.api.addProduto(produto)
    }

    suspend fun listProduto(): Response<List<Produto>> {
        return RetrofitInstance.api.listProduto()
    }

    suspend fun updateProduto(produto: Produto): Response<Produto>{
        return RetrofitInstance.api.updateProduto(produto)
    }

}