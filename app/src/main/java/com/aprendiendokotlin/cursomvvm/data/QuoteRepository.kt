package com.aprendiendokotlin.cursomvvm.data

import com.aprendiendokotlin.cursomvvm.data.database.dao.QuoteDao
import com.aprendiendokotlin.cursomvvm.data.database.entities.QuoteEntity
import com.aprendiendokotlin.cursomvvm.domain.model.Quote
import com.aprendiendokotlin.cursomvvm.data.network.QuoteService
import com.aprendiendokotlin.cursomvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api : QuoteService, private val quoteDao: QuoteDao){

//    private val api = QuoteService()
    suspend fun getAllQuotesFromApi():List<Quote>{
        val response = api.getQuotes()
        return response.map { it.toDomain()}
    }

    suspend fun getAllQuotesFromDataBase():List<Quote>{
        val response = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quote: List<QuoteEntity>){
        quoteDao.insertAll(quote)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}