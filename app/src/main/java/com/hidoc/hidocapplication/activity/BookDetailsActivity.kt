package com.hidoc.hidocapplication.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.hidoc.hidocapplication.R
import kotlinx.android.synthetic.main.activity_book_details.*


class BookDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)
        val booktitle= intent.getStringExtra("booktitle")
        val author=intent.getStringExtra("author")
        val totalPage= intent.getStringExtra("totalPage")
        val image= intent.getStringExtra("image")
        val infolink=intent.getStringExtra("infolink")
        val description= intent.getStringExtra("description")
        val rating= intent.getFloatExtra("rating", 0.0f)
        supportActionBar?.title= booktitle
        ivBookImage.load(image){
            crossfade(600)
        }
        tvBookTitle.text=booktitle
        tvAuthor.text=author
        tvTotalPages.text="Total Pages - ${totalPage}"
        ratingBar.rating= rating
        tvDescription.text=description
        btnBookInfo.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(infolink))
            startActivity(browserIntent)
        }
    }
}