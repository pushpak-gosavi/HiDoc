package com.hidoc.hidocapplication.fragments.news

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hidoc.hidocapplication.R
import com.hidoc.hidocapplication.adapters.NewsAdapter
import com.hidoc.hidocapplication.mainviewmodel.MainViewModel
import com.hidoc.hidocapplication.mainviewmodel.MainViewModelFactory
import com.hidoc.hidocapplication.repository.NewsRepository
import com.hidoc.hidocapplication.utils.Constants.Companion.News_Api_Key
import kotlinx.android.synthetic.main.fragment_news.view.*

class NewsFragment : Fragment() {
    private lateinit var viewModel:MainViewModel
    private lateinit var viewlayout:View
    private val newsAdapter by lazy { NewsAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository= NewsRepository()
        val viewModelFractory= MainViewModelFactory(repository)
        viewModel= ViewModelProvider(this,viewModelFractory).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        viewlayout= inflater.inflate(R.layout.fragment_news, container, false)
        showShimmer()
        getNews("India")
        viewlayout.edtSearchNews.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                getNews(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        return viewlayout
    }
    private fun getNews(q:String) {
        viewModel.getNews(getQuries(q))
        viewModel.newsResposne.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                newsAdapter.addNewsItels(response.body()!!.articles)
                viewlayout.rvRecyclerView_News.adapter= newsAdapter
                hideShimmer()
                //Toast.makeText(viewlayout.context, response.body().toString(), Toast.LENGTH_SHORT).show()
            } else {
                //Toast.makeText(viewlayout.context, response.errorBody().toString(), Toast.LENGTH_SHORT).show()
                hideShimmer()
            }
        })
    }

    private fun getQuries(q:String):Map<String,String>{
        val quries:HashMap<String,String> = HashMap<String,String>()
        quries["q"]=q
        quries["sortBy"]="publishedAt"
        quries["apiKey"]=News_Api_Key
        return quries
    }
    private fun showShimmer(){
        viewlayout.rvRecyclerView_News.showShimmer()
    }
    private fun hideShimmer(){
        viewlayout.rvRecyclerView_News.hideShimmer()
    }
}