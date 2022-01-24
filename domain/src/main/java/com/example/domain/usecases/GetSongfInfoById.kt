package com.example.domain.usecases

import com.example.domain.contracts.ISongInfoRepository
import com.example.domain.models.SongInfo
import com.example.domain.models.SongPreview

class GetSongfInfoById(private val repository: ISongInfoRepository) {
    operator fun invoke(id:String,callback: (SongInfo) -> Unit) {
        repository.getSongInfoById(id,callback)
    }
}