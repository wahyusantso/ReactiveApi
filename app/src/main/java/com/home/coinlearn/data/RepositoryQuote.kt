package com.home.coinlearn.data

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.home.coinlearn.data.network.ApiService
import com.home.coinlearn.data.network.IRepositoryQuote
import com.home.coinlearn.data.network.response.Quote
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryQuote(private val apiService: ApiService): IRepositoryQuote {
    private val compositeDisposable = CompositeDisposable()//handle observer unsubscribe
    private val _resultData = MutableLiveData<Quote>()
    val resultData: LiveData<Quote> = _resultData

    @SuppressLint("CheckResult")
    override fun getRandomQuote(): LiveData<Quote> {
        val client = apiService.getQuate()
            .subscribeOn(Schedulers.io())//mendefinisikan proses mengirim data dilakukan di mana.
            .observeOn(AndroidSchedulers.mainThread()) //mendefinisikan proses menerima data dilakukan di mana.
            .doOnComplete {
                compositeDisposable.clear()
            }
            .subscribe(
                { response ->
                    val quote = Quote(
                        author = response.author,
                        en = response.en,
                        id = response.id
                    )
                    _resultData.postValue(quote)
                },
                { error ->
                    Log.e("RepositoryQuote", error.toString())
                }
            )
        compositeDisposable.add(client)
        return resultData
    }
}
/*
Untuk menentukan thread yang digunakan, bisa menggunakan beberapa pilihan Schedulers berikut:

Schedulers.io : untuk melakukan proses di I/O Thread seperti memanggil api dan menulis database.
Schedulers.computation : untuk melakukan proses dengan kebutuhan CPU yang tinggi seperti convert bitmap atau compressing.
Schedulers.newThread : untuk membuat thread baru untuk setiap unit proses.
Schedulers.single : berguna jika Anda memiliki beberapa proses yang berasal dari tempat berbeda dan ingin menggabungkannya.
Schedulers.from(...) : untuk membuat custom scheduler sendiri dengan bantuan Executor.
AndroidSchedulers.mainThread() : untuk menerima hasil proses di Main Thread Android. Di sinilah tempat library RxAndroid berperan.
 */

/*
Observable : sebuah perosotan yang berisi data stream, dalam hal ini adalah bola.
Observer : orang yang mengamati dan siap menerima data.
Publisher : orang yang membuat dan mengirimkan data.
Subscribe : proses observer agar dapat menerima data dari Publisher.
Emit : proses Publisher mengirimkan data ke observer.
 */

/*
CompositeDisposable:
clear : Jika Anda ingin menghapus dan menggunakannya lagi.
dispose : Jika Anda ingin menghapus dan tidak menggunakannya kembali, fungsi ini akan memberikan flag isDispose = true.
 */