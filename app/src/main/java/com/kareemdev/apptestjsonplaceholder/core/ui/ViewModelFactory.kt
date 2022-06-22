package com.kareemdev.apptestjsonplaceholder.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kareemdev.apptestjsonplaceholder.core.di.Injection
import com.kareemdev.apptestjsonplaceholder.core.domain.usecase.JsonUseCase
import com.kareemdev.apptestjsonplaceholder.home.HomeViewModel

class ViewModelFactory private constructor(private val jsonUseCase: JsonUseCase): ViewModelProvider.NewInstanceFactory(){
    companion object{
        @Volatile
        private var instance : ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this){
            instance ?: ViewModelFactory(Injection.provideJsonUseCase(context))
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T  =
        when{
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(jsonUseCase) as T
            }
            else -> throw  Throwable("Unknown ViewModel class: " + modelClass.name)
        }

}