package com.home.coinlearn

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.toLiveData
import com.home.coinlearn.data.network.IRepositoryQuote
import com.home.coinlearn.data.network.response.Quote

class MainViewModel(private val repository: IRepositoryQuote): ViewModel() {

    //toLivedata = convert data flowable to livedata
    val myQuote: LiveData<Quote> = repository.getRandomQuote()
}