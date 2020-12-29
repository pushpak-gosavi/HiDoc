package com.hidoc.hidocapplication.apiServices

import com.hidoc.hidocapplication.models.book.BookModel
import com.hidoc.hidocapplication.models.news.Article
import com.hidoc.hidocapplication.models.news.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface APIS {
    @GET("/v2/everything")
    suspend fun getNews(
        @QueryMap queries:Map<String,String>
    ):Response<NewsModel>

    @GET("v1/volumes")
    suspend fun getBooks(
            @Query ("q") q:String
    ):Response<BookModel>
}