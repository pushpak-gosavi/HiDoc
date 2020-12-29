package com.hidoc.hidocapplication.models.book


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
)