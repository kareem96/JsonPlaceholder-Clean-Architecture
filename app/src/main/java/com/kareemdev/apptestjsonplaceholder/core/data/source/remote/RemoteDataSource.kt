package com.kareemdev.apptestjsonplaceholder.core.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kareemdev.apptestjsonplaceholder.core.data.source.remote.network.ApiResponse
import com.kareemdev.apptestjsonplaceholder.core.data.source.remote.network.ApiService
import com.kareemdev.apptestjsonplaceholder.core.data.source.remote.response.JsonResponse
import com.kareemdev.apptestjsonplaceholder.core.data.source.remote.response.ListJsonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val apiService: ApiService) {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(service);
        }
    }

    fun getAllJson(): LiveData<ApiResponse<List<JsonResponse>>>{
        val resultData = MutableLiveData<ApiResponse<List<JsonResponse>>>()

        val client = apiService.getList()
        client.enqueue(object : Callback<ListJsonResponse>{
            override fun onResponse(call: Call<ListJsonResponse>, response: Response<ListJsonResponse>) {
                val dataArray = response.body()?.places
                resultData.value = if(dataArray != null) ApiResponse.Success(dataArray) else ApiResponse.Empty
            }

            override fun onFailure(call: Call<ListJsonResponse>, t: Throwable) {
                resultData.value = ApiResponse.Error(t.message.toString())
                Log.e("RemoteDataSource: ", t.message.toString())
            }

        })
        return resultData
    }
}