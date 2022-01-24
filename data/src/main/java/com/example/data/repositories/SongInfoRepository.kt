package com.example.data.repositories

import com.example.data.fakedb.SongData
import com.example.domain.contracts.ISongInfoRepository
import com.example.domain.models.SongInfo

class SongInfoRepository:ISongInfoRepository{
    override fun getSongInfoById(id: String, callback: (SongInfo) -> Unit) {
        if(SongData.data.containsKey(id))
        callback(SongData.data.getValue(id))
        else callback(SongData.defaultSongData)
    }
}