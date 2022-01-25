package com.example.shcheprov_homeworks.splashscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.repositories.InitializeRepository
import com.example.domain.models.InitializationState
import com.example.domain.usecases.Initialize

class LoadingViewModel:ViewModel() {
    private val _loadingStateLiveData = MutableLiveData<InitializationState>()
    val loadingStateLiveData:LiveData<InitializationState> = _loadingStateLiveData
    fun initializeApp(){
        val initialize = Initialize(InitializeRepository())
        initialize(::updateInitializeState)
    }
    private fun updateInitializeState(state:InitializationState){
        _loadingStateLiveData.value=state
    }
}