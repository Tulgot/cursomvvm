package com.aprendiendokotlin.cursomvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aprendiendokotlin.cursomvvm.domain.GetQuotesUseCase
import com.aprendiendokotlin.cursomvvm.domain.GetRandomQuoteUseCase
import com.aprendiendokotlin.cursomvvm.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private var getQuoteUseCase : GetQuotesUseCase,
                                         private var getRandomQuoteUseCase : GetRandomQuoteUseCase): ViewModel() {

    val quoteModel = MutableLiveData<Quote?>()
    val isLoading = MutableLiveData<Boolean>()

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

    fun randomQuote(){
        viewModelScope.launch {
            isLoading.postValue(true)

            val quote = getRandomQuoteUseCase()
            if (quote != null){
                quoteModel.postValue(quote)
                isLoading.postValue(false)
            }
            isLoading.postValue(false)
        }
    }


}