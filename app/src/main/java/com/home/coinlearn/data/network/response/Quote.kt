package com.home.coinlearn.data.network.response

import com.google.gson.annotations.SerializedName

data class Quote(
    @field:SerializedName("author")
    val author: String,
    @field:SerializedName("en")
    val en: String,
    @field:SerializedName("id")
    val id: String
)