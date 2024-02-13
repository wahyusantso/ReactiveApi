package com.home.coinlearn.data.network

import androidx.lifecycle.LiveData
import com.home.coinlearn.data.network.response.Quote
import io.reactivex.Flowable

interface IRepositoryQuote {
    fun getRandomQuote(): LiveData<Quote>
}