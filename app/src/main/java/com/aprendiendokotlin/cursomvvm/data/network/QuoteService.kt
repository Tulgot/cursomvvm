package com.aprendiendokotlin.cursomvvm.data.network

import com.aprendiendokotlin.cursomvvm.core.RetrofitHelper
import com.aprendiendokotlin.cursomvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api:QuoteApiClient){

//    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }

    }
}