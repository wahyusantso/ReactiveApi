package com.home.coinlearn.di

import com.home.coinlearn.MainViewModel
import com.home.coinlearn.data.RepositoryQuote
import com.home.coinlearn.data.network.ApiService
import com.home.coinlearn.data.network.IRepositoryQuote
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appmodule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://quote-api.dicoding.dev")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
    single<IRepositoryQuote> {
        RepositoryQuote(get())
    }
    viewModel {
        MainViewModel(get())
    }
}