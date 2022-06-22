package com.kareemdev.apptestjsonplaceholder.core.di

import android.content.Context
import com.kareemdev.apptestjsonplaceholder.core.data.JsonRepository
import com.kareemdev.apptestjsonplaceholder.core.data.source.local.LocalDataSource
import com.kareemdev.apptestjsonplaceholder.core.data.source.local.room.JsonDatabase
import com.kareemdev.apptestjsonplaceholder.core.data.source.remote.RemoteDataSource
import com.kareemdev.apptestjsonplaceholder.core.data.source.remote.network.ApiConfig
import com.kareemdev.apptestjsonplaceholder.core.domain.repository.IJsonRepository
import com.kareemdev.apptestjsonplaceholder.core.domain.usecase.JsonInteractor
import com.kareemdev.apptestjsonplaceholder.core.domain.usecase.JsonUseCase
import com.kareemdev.apptestjsonplaceholder.core.utils.AppExecutors

object Injection {
    fun provideRepostiory(context: Context): IJsonRepository{
        val database = JsonDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val appExecutors = AppExecutors()
        val localDataSource = LocalDataSource.getInstance(database.jsonDao())
        return JsonRepository.getInstance(remoteDataSource,appExecutors, localDataSource)
    }

    fun provideJsonUseCase(context: Context): JsonUseCase{
        val repository = provideRepostiory(context)
        return JsonInteractor(repository)
    }
}