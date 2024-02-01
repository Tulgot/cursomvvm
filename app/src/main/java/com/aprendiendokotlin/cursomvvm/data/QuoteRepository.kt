package com.aprendiendokotlin.cursomvvm.data

import com.aprendiendokotlin.cursomvvm.data.model.QuoteModel
import com.aprendiendokotlin.cursomvvm.data.model.QuoteProvider
import com.aprendiendokotlin.cursomvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api : QuoteService, private val quoteProvider:QuoteProvider){

//    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}