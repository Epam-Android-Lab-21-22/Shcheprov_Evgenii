package com.example.data.repositories

import com.example.data.fakedb.SongPreviewData
import com.example.domain.contracts.ISongPreviewRepository
import com.example.domain.models.SongPreview

class SongPreviewRespsiotory: ISongPreviewRepository {
    override fun getSongPreviewList(callback: (List<SongPreview>) -> Unit) {
        callback(SongPreviewData.data)
    }
}