package com.aprendiendokotlin.cursomvvm.ui.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.aprendiendokotlin.cursomvvm.data.QuoteRepository
import com.aprendiendokotlin.cursomvvm.data.network.QuoteApiClient
import com.aprendiendokotlin.cursomvvm.databinding.ActivityMainBinding
import com.aprendiendokotlin.cursomvvm.domain.GetQuotesUseCase
import com.aprendiendokotlin.cursomvvm.ui.viewmodel.QuoteViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()
    private val TAG = "quotefail"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvAuthor.text = currentQuote.author
            binding.tvQuote.text = currentQuote.quote
        })

        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }

    }
}