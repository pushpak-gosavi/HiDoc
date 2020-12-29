package com.hidoc.hidocapplication.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.hidoc.hidocapplication.R
import com.hidoc.hidocapplication.activity.BookDetailsActivity
import com.hidoc.hidocapplication.models.book.Item
import kotlinx.android.synthetic.main.card_row_books.view.*

class BookAdapter: RecyclerView.Adapter<BookAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    var bookList= emptyList<Item>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view= LayoutInflater.from(parent.context)
               .inflate(R.layout.card_row_books,parent,false)
        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem= bookList[position]
        val authors= currentItem.volumeInfo.authors
        if(!authors.isNullOrEmpty()) {
            holder.itemView.tvBookAuthor.text = authors.toString()
        }else {
            holder.itemView.tvBookAuthor.text="N.A."
        }
        /*for (i in authors){
            holder.itemView.tvBookAuthor.text=i
        } */
        holder.itemView.tvBookTitle.text= currentItem.volumeInfo.title
        holder.itemView.tvPageCount.text= "Total pages :- ${currentItem.volumeInfo.pageCount.toString()}"
        holder.itemView.ratingBar.rating= currentItem.volumeInfo.averageRating
        holder.itemView.ratingBar.setStepSize(currentItem.volumeInfo.averageRating);// to show to stars
        val ivUrl= currentItem.volumeInfo.imageLinks.thumbnail
        holder.itemView.ivBook.load(ivUrl){
            crossfade(600)
            placeholder(R.drawable.ic_baseline_image_24)
        }
        holder.itemView.setOnClickListener { view->
            val intent= Intent(view.context,BookDetailsActivity::class.java)
            intent.putExtra("booktitle",currentItem.volumeInfo.title)
            intent.putExtra("author",authors.toString())
            intent.putExtra("totalPage",currentItem.volumeInfo.pageCount.toString())
            intent.putExtra("image",currentItem.volumeInfo.imageLinks.thumbnail)
            intent.putExtra("infolink",currentItem.volumeInfo.infoLink)
            intent.putExtra("description",currentItem.volumeInfo.description)
            intent.putExtra("rating",currentItem.volumeInfo.averageRating)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
       return bookList.size
    }
    fun setBookData(list:List<Item>){
        bookList= list
        notifyDataSetChanged()
    }
}