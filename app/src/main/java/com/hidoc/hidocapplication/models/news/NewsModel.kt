package com.hidoc.hidocapplication.models.news


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsModel(
    @SerializedName("articles")
    val articles: List<Article>
):Parcelable