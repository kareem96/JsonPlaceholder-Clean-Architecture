package com.kareemdev.apptestjsonplaceholder.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.kareemdev.apptestjsonplaceholder.core.data.source.local.LocalDataSource
import com.kareemdev.apptestjsonplaceholder.core.data.source.remote.RemoteDataSource
import com.kareemdev.apptestjsonplaceholder.core.data.source.remote.network.ApiResponse
import com.kareemdev.apptestjsonplaceholder.core.data.source.remote.response.JsonResponse
import com.kareemdev.apptestjsonplaceholder.core.domain.model.Json
import com.kareemdev.apptestjsonplaceholder.core.domain.repository.IJsonRepository
import com.kareemdev.apptestjsonplaceholder.core.utils.AppExecutors
import com.kareemdev.apptestjsonplaceholder.core.utils.DataMapper

class JsonRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors,
    private val localDataSource: LocalDataSource,
) : IJsonRepository{

    companion object{
        @Volatile
        private var instance: JsonRepository? = null
        fun getInstance(
            remoteDataSource: RemoteDataSource,
            appExecutors: AppExecutors,
            localData: LocalDataSource
        ):JsonRepository = instance ?: synchronized(this){
            instance ?: JsonRepository(remoteDataSource, appExecutors, localData)
        }
    }

    override fun getAllJson(): LiveData<Resource<List<Json>>> = object : NetworkBoundResource<List<Json>, List<JsonResponse>>(appExecutors){
        override fun loadFromDB(): LiveData<List<Json>> {
            return Transformations.map(localDataSource.getAllJson()){
                DataMapper.mapEntitiesToDomain(it)
            }
        }

        override fun shouldFetch(data: List<Json>?): Boolean =
            data == null || data.isEmpty()

        override fun createCall(): LiveData<ApiResponse<List<JsonResponse>>> =
            remoteDataSource.getAllJson()

        override fun saveCallResult(data: List<JsonResponse>) {
            val jsonList = DataMapper.mapResponsesToEntities(data)
            localDataSource.insertJson(jsonList)
        }

    }.asLiveData()
}