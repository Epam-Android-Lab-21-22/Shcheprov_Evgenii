package com.example.domain.contracts

import com.example.domain.models.SongInfo


interface ISongInfoRepository {
    fun getSongInfoById(id:String, callback:(SongInfo)->Unit)
}