package com.kareemdev.apptestjsonplaceholder.core.domain.usecase

import androidx.lifecycle.LiveData
import com.kareemdev.apptestjsonplaceholder.core.data.Resource
import com.kareemdev.apptestjsonplaceholder.core.domain.model.Json

interface JsonUseCase {
    fun getAllJson(): LiveData<Resource<List<Json>>>
}