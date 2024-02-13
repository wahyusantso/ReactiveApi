package com.home.coinlearn.data.network

import com.home.coinlearn.data.network.response.Quote
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/random")
    fun getQuate(): Flowable<Quote>

}
/*
Tipe Observables(berisi data stream) pada RxJava
Observable : untuk emit data stream tanpa batas. Digunakan untuk proses yang cepat seperti interaksi UI.

Flowable : untuk emit data stream tanpa batas dengan tambahan back pressure strategy.
           Digunakan untuk proses yang lama, seperti mengambil data dari API atau database yang berubah-ubah dalam beberapa detik, seperti jumlah Like & Comment.

Single : untuk emit satu data saja. Digunakan untuk mengambil data yang tidak berubah-ubah dan cukup sekali saja.
 */