package com.kareemdev.apptestjsonplaceholder.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListJsonResponse(
    val places: ArrayList<JsonResponse>,
)