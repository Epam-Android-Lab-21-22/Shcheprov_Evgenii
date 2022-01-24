package com.example.domain.usecases

import com.example.domain.contracts.IInitizlizeRepository
import com.example.domain.models.InitializationState

class Initialize(private val initilaizeRepository: IInitizlizeRepository) {
    operator fun invoke(callback: (InitializationState) -> Unit) {
        initilaizeRepository.initiaize(callback)
    }

}