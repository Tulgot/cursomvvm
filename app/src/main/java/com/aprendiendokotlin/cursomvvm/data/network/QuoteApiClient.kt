package com.aprendiendokotlin.cursomvvm.data.network

import com.aprendiendokotlin.cursomvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/v1/quotes/5")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}