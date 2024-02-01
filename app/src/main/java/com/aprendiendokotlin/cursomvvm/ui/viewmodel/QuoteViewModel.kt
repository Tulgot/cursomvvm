package com.aprendiendokotlin.cursomvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aprendiendokotlin.cursomvvm.data.model.QuoteModel
import com.aprendiendokotlin.cursomvvm.data.model.QuoteProvider
import com.aprendiendokotlin.cursomvvm.domain.GetQuotesUseCase
import com.aprendiendokotlin.cursomvvm.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private var getQuoteUseCase : GetQuotesUseCase,
                                         private var getRandomQuoteUseCase : GetRandomQuoteUseCase): ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

//    val getQuoteUseCase = GetQuotesUseCase()
//    val getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun randomQuote(){
//        val currentQuote = QuoteProvider.random()
//        quoteModel.postValue(currentQuote)
        viewModelScope.launch {
            isLoading.postValue(true)

            val quote = getRandomQuoteUseCase()
            if (quote != null){
                quoteModel.postValue(quote)
                isLoading.postValue(false)
            }
        }

        isLoading.postValue(false)

    }

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)

            val result = getQuoteUseCase()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
}