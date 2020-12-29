package com.hidoc.hidocapplication.models.book


import com.google.gson.annotations.SerializedName

data class VolumeInfo(
    @SerializedName("authors")
    val authors: List<String>?,
    @SerializedName("averageRating")
    val averageRating: Float,
    @SerializedName("categories")
    val categories: List<String>,
    @SerializedName("contentVersion")
    val contentVersion: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("imageLinks")
    val imageLinks: ImageLinks,
    @SerializedName("infoLink")
    val infoLink: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("pageCount")
    val pageCount: Int,
    @SerializedName("publishedDate")
    val publishedDate: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("ratingsCount")
    val ratingsCount: Int,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String
)