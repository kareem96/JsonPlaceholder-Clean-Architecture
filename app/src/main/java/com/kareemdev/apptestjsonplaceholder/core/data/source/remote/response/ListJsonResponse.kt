package com.kareemdev.apptestjsonplaceholder.core.data.source.remote.response

import com.google.gson.annotations.SerializedName
import retrofit2.Call

data class ListJsonResponse(
    val places: List<JsonResponse>,
)