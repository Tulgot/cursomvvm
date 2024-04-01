package com.aprendiendokotlin.cursomvvm.domain

import com.aprendiendokotlin.cursomvvm.data.QuoteRepository
import com.aprendiendokotlin.cursomvvm.data.database.entities.toDatabase
import com.aprendiendokotlin.cursomvvm.data.model.QuoteModel
import com.aprendiendokotlin.cursomvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor( private val repository : QuoteRepository) {

    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDataBase()
        }
    }

}