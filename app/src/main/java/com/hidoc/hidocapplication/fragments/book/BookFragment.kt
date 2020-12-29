package com.hidoc.hidocapplication.fragments.book

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hidoc.hidocapplication.R
import com.hidoc.hidocapplication.adapters.BookAdapter
import com.hidoc.hidocapplication.adapters.NewsAdapter
import com.hidoc.hidocapplication.mainviewmodel.MainViewModel
import com.hidoc.hidocapplication.mainviewmodel.MainViewModelFactory
import com.hidoc.hidocapplication.repository.NewsRepository
import kotlinx.android.synthetic.main.fragment_book.view.*

class BookFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    private lateinit var myView:View
    private val bookAdapter by lazy { BookAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository=NewsRepository()
        val mainViewModelFactory= MainViewModelFactory(repository)
        viewModel= ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        myView= inflater.inflate(R.layout.fragment_book, container, false)
        showShimmer()
        getBook("random")
        myView.edtSearchBook.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                getBook(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
        return myView
    }
    private fun getBook(q:String) {
        viewModel.getBooks(q)
        viewModel.bookResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                bookAdapter.setBookData(response.body()!!.items)
                myView.rvRecyclerView_Book.adapter= bookAdapter
                hideShimmer()
                //Toast.makeText(viewlayout.context, response.body().toString(), Toast.LENGTH_SHORT).show()
            } else {
                //Toast.makeText(viewlayout.context, response.errorBody().toString(), Toast.LENGTH_SHORT).show()
                hideShimmer()
            }
        })
    }
    private fun showShimmer(){
        myView.rvRecyclerView_Book.showShimmer()
    }
    private fun hideShimmer(){
        myView.rvRecyclerView_Book.hideShimmer()
    }
}