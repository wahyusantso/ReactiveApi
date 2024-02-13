package com.home.coinlearn

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.home.coinlearn.data.network.response.Quote
import com.home.coinlearn.ui.theme.CoinLearnTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinLearnTheme {
                //define viewmodel
                val viewModel = getViewModel<MainViewModel>()
                //observer variable viewmodel
                val quote = viewModel.myQuote.observeAsState()
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    Alignment.CenterHorizontally
                ) {
                    quote.value?.en?.let {
                        Text(
                            text = it,
                            fontSize = 18.sp,
                            fontStyle = FontStyle.Normal,
                            textAlign = TextAlign.Justify,
                            modifier = Modifier
                                .padding(start = 14.dp, end = 14.dp, bottom = 14.dp)
                        )
                    }
                    quote.value?.let {
                        Text(
                            text = it.author,
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Italic,
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(start = 14.dp, end = 14.dp)
                        )
                    }
                }
            }
        }
    }
}