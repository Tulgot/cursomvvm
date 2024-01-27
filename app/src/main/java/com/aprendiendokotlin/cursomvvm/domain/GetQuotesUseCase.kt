package com.aprendiendokotlin.cursomvvm.domain

import com.aprendiendokotlin.cursomvvm.data.QuoteRepository
import com.aprendiendokotlin.cursomvvm.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}