package com.hidoc.hidocapplication.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.hidoc.hidocapplication.R
import com.hidoc.hidocapplication.activity.NewsDetailsActivity
import com.hidoc.hidocapplication.models.news.Article
import kotlinx.android.synthetic.main.card_row_news.view.*

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    var newsList= emptyList<Article>()
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view= LayoutInflater.from(parent.context)
               .inflate(R.layout.card_row_news,parent,false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem= newsList[position]
        holder.itemView.tvTitle_News.text= currentItem.title
        holder.itemView.tv_Description_News.text= currentItem.description
        holder.itemView.tvPublishAt_News.text= currentItem.publishedAt
        holder.itemView.ivNewsImage.load(currentItem.urlToImage){
            crossfade(600)
            transformations(CircleCropTransformation())
        }
        holder.itemView.setOnClickListener {view ->
            val intent= Intent(view.context,NewsDetailsActivity::class.java)
            intent.putExtra("title",currentItem.title)
            intent.putExtra("date",currentItem.publishedAt)
            intent.putExtra("description",currentItem.description)
            intent.putExtra("author",currentItem.author)
            intent.putExtra("newsImage",currentItem.urlToImage)
            view.context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return newsList.size
    }
    fun addNewsItels( list: List<Article>){
        newsList = list
        notifyDataSetChanged()
    }
}