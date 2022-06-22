package com.kareemdev.apptestjsonplaceholder.core.domain.repository

import androidx.lifecycle.LiveData
import com.kareemdev.apptestjsonplaceholder.core.data.Resource
import com.kareemdev.apptestjsonplaceholder.core.domain.model.Json

interface IJsonRepository {
    fun getAllJson(): LiveData<Resource<List<Json>>>
}