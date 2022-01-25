package com.example.domain.usecases

import com.example.domain.contracts.ISongPreviewRepository
import com.example.domain.models.InitializationState
import com.example.domain.models.SongPreview

class GetSongPreviewList(private val repository: ISongPreviewRepository) {
    operator fun invoke(callback: (List<SongPreview>) -> Unit) {
        repository.getSongPreviewList(callback)
    }
}