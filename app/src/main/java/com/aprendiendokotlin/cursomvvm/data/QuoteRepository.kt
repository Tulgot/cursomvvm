package com.aprendiendokotlin.cursomvvm.data

import com.aprendiendokotlin.cursomvvm.data.model.QuoteModel
import com.aprendiendokotlin.cursomvvm.data.model.QuoteProvider
import com.aprendiendokotlin.cursomvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}