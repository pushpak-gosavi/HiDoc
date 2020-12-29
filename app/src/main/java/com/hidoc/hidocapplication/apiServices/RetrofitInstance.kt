package com.hidoc.hidocapplication.apiServices

import com.hidoc.hidocapplication.utils.Constants.Companion.NEWS_BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val client= OkHttpClient.Builder().build()
     val retrofit:Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(NEWS_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: APIS by lazy {
        retrofit.create(APIS::class.java)
    }
    // Books Retrofit
    val bookRetrofit:Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/books/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    val bookApi: APIS by lazy {
        bookRetrofit.create(APIS::class.java)
    }
}