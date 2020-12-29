package com.hidoc.hidocapplication.mainviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hidoc.hidocapplication.models.book.BookModel
import com.hidoc.hidocapplication.models.news.NewsModel
import com.hidoc.hidocapplication.repository.NewsRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel (private val repository: NewsRepository):ViewModel(){
    val newsResposne:MutableLiveData<Response<NewsModel>> = MutableLiveData()
    // book response
    val bookResponse:MutableLiveData<Response<BookModel>> = MutableLiveData()
    fun getNews(quries:Map<String,String>){
        viewModelScope.launch {
            val response= repository.getNews(quries)
            newsResposne.value= response
        }
    }
    fun getBooks(q:String){
        viewModelScope.launch {
            val response= repository.getBooks(q)
            bookResponse.value= response
        }
    }
}