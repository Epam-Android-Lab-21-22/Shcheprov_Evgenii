package com.example.domain.contracts

import com.example.domain.models.InitializationState

interface IInitizlizeRepository {
    fun initiaize(callback:(InitializationState)->Unit)
}