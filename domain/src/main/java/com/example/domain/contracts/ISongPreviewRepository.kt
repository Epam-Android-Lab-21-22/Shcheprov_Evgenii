package com.example.domain.contracts

import com.example.domain.models.SongPreview

interface ISongPreviewRepository {
    fun getSongPreviewList(callback:(List<SongPreview>)->Unit)
}