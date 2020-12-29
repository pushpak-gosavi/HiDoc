package com.hidoc.hidocapplication.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import coil.load
import com.hidoc.hidocapplication.R
import kotlinx.android.synthetic.main.activity_news_details.*

class NewsDetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        val getTitle= intent.getStringExtra("title")
        val getDate= intent.getStringExtra("date")
        val getDescription= intent.getStringExtra("description")
        val getImage= intent.getStringExtra("newsImage")
        val getAuthor= intent.getStringExtra("author")
        supportActionBar?.title= getTitle
        tvNewsTitle_d.text=getTitle
        tv_newsDate_d.text=getDate
        tv_Description_News_d.text= getDescription
        tv_newsAuthor_d.text= "- ${getAuthor}"
        ivNewsImage_d.load(getImage){
            crossfade(600)
        }
    }
}