package com.kareemdev.apptestjsonplaceholder.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class JsonResponse (
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("userId")
    val userId: Int,
    @field:SerializedName("title")
    val title: String,
)