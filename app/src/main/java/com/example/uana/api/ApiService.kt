package com.example.uana.api

import com.example.uana.model.Categoria
import com.example.uana.model.Produto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {

    @GET("categoria")
    suspend fun listCategoria(): Response<List<Categoria>>

    @POST("produto")
    suspend fun addProduto(
        @Body produto: Produto
    ): Response<Produto>

    @GET("produto")
    suspend fun listProduto(): Response<List<Produto>>

    @PUT("produto")
    suspend fun updateProduto(
        @Body produto: Produto
    ): Response<Produto>

}