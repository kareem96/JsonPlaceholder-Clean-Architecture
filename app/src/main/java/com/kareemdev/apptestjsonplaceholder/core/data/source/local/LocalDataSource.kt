package com.kareemdev.apptestjsonplaceholder.core.data.source.local

import androidx.lifecycle.LiveData
import com.kareemdev.apptestjsonplaceholder.core.data.source.local.entity.JsonEntity
import com.kareemdev.apptestjsonplaceholder.core.data.source.local.room.JsonDao

class LocalDataSource private constructor(private val jsonDao: JsonDao){
    companion object{
        private var instance: LocalDataSource? = null

        fun getInstance(jsonDao: JsonDao): LocalDataSource =
            instance ?: synchronized(this){
                instance ?: LocalDataSource(jsonDao)
            }
    }

    fun getAllJson(): LiveData<List<JsonEntity>> = jsonDao.getAllJson()

    fun insertJson(jsonList: List<JsonEntity>) = jsonDao.insertJson(jsonList)
}