package com.home.coinlearn.data

import android.util.Log
import com.home.coinlearn.data.network.ApiService
import com.home.coinlearn.data.network.IRepositoryQuote
import com.home.coinlearn.data.network.response.Quote
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryQuote(private val apiService: ApiService): IRepositoryQuote {

    override fun getRandomQuote() {
        val response = apiService.getQuate()
        response.enqueue(object : Callback<Quote> {
            override fun onResponse(call: Call<Quote>, response: Response<Quote>) {
                val responseBody = response.body()
                if (responseBody != null) {
                   println("$responseBody")
                }
            }

            override fun onFailure(call: Call<Quote>, t: Throwable) {
                Log.e("Repository", t.toString())
            }
        })
    }
}