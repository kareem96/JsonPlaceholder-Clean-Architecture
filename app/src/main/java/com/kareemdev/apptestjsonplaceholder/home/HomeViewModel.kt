package com.kareemdev.apptestjsonplaceholder.home

import androidx.lifecycle.ViewModel
import com.kareemdev.apptestjsonplaceholder.core.domain.usecase.JsonUseCase

class HomeViewModel(jsonUseCase: JsonUseCase) : ViewModel(){
    val jsonUser = jsonUseCase.getAllJson()
}