package com.aprendiendokotlin.cursomvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aprendiendokotlin.cursomvvm.data.model.QuoteModel
import com.aprendiendokotlin.cursomvvm.data.model.QuoteProvider
import com.aprendiendokotlin.cursomvvm.domain.GetQuotesUseCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val getQuoteUseCase = GetQuotesUseCase()

    fun randomQuote(){
//        val currentQuote = QuoteProvider.random()
//        quoteModel.postValue(currentQuote)
    }

    fun onCreate() {
        viewModelScope.launch {
            val result = getQuoteUseCase()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
            }
        }
    }
}