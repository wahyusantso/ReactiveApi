package com.home.coinlearn

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.home.coinlearn.ui.theme.CoinLearnTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinLearnTheme {
                val viewModel = getViewModel<MainViewModel>()
                viewModel.quoteRandom()
            }
        }
    }
}