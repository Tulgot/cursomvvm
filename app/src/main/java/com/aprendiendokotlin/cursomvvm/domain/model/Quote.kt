package com.aprendiendokotlin.cursomvvm.domain.model

import com.aprendiendokotlin.cursomvvm.data.database.entities.QuoteEntity
import com.aprendiendokotlin.cursomvvm.data.model.QuoteModel

data class Quote (val quote: String, val author: String)


fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)
