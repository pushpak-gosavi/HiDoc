package com.hidoc.hidocapplication.repository

import com.hidoc.hidocapplication.apiServices.RetrofitInstance
import com.hidoc.hidocapplication.models.book.BookModel
import com.hidoc.hidocapplication.models.news.NewsModel
import retrofit2.Response

class NewsRepository {
    suspend fun getNews(quires:Map<String,String>):Response<NewsModel>{
        return RetrofitInstance.api.getNews(quires)
    }
    suspend fun getBooks(q:String):Response<BookModel>{
        return RetrofitInstance.bookApi.getBooks(q)
    }
}