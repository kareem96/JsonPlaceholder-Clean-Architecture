package com.kareemdev.apptestjsonplaceholder.core.domain.usecase

import androidx.lifecycle.LiveData
import com.kareemdev.apptestjsonplaceholder.core.data.Resource
import com.kareemdev.apptestjsonplaceholder.core.domain.model.Json
import com.kareemdev.apptestjsonplaceholder.core.domain.repository.IJsonRepository

class JsonInteractor(private val jsonRepository: IJsonRepository): JsonUseCase {
    override fun getAllJson(): LiveData<Resource<List<Json>>> {
        return jsonRepository.getAllJson()
    }
}