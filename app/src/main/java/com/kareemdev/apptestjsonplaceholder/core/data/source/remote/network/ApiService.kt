package com.kareemdev.apptestjsonplaceholder.core.data.source.remote.network

import com.kareemdev.apptestjsonplaceholder.core.data.source.remote.response.ListJsonResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    fun getList(): Call<ListJsonResponse>
}