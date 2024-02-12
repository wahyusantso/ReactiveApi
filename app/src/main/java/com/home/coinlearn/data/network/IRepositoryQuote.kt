package com.home.coinlearn.data.network

import com.home.coinlearn.data.network.response.Quote

interface IRepositoryQuote {
    fun getRandomQuote()
}