package com.aprendiendokotlin.cursomvvm.domain

import com.aprendiendokotlin.cursomvvm.data.QuoteRepository
import com.aprendiendokotlin.cursomvvm.data.model.QuoteModel
import com.aprendiendokotlin.cursomvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository ) {
    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromDataBase()
        if (!quotes.isNullOrEmpty()) {
//            val ramdonNumber = (0..quotes.size-1).random()
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}