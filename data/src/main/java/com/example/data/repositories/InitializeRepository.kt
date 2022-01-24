package com.example.data.repositories

import com.example.domain.models.InitializationState

import com.example.domain.contracts.IInitizlizeRepository
import kotlinx.coroutines.*

class InitializeRepository:IInitizlizeRepository {
    override fun initiaize(callback: (InitializationState) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            CoroutineScope(Dispatchers.Main).launch {
                callback(InitializationState(true))
            }
        }
    }


}