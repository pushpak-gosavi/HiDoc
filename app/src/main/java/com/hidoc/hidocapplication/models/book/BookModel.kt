package com.hidoc.hidocapplication.models.book


import com.google.gson.annotations.SerializedName

data class BookModel(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("totalItems")
    val totalItems: Int
)