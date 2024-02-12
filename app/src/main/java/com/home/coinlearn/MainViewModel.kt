package com.home.coinlearn

import androidx.lifecycle.ViewModel
import com.home.coinlearn.data.network.IRepositoryQuote

class MainViewModel(private val repository: IRepositoryQuote): ViewModel() {
    fun quoteRandom() {
        return repository.getRandomQuote()
    }
}