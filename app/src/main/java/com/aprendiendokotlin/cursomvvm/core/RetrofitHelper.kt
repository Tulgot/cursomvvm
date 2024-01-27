package com.aprendiendokotlin.cursomvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.breakingbadquotes.xyz/v1")
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }
}