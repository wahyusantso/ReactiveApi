package com.home.coinlearn.data.network

import com.home.coinlearn.data.network.response.Quote
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/random")
    fun getQuate(): Call<Quote>
}