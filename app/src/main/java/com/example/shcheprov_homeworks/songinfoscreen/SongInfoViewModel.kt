package com.example.shcheprov_homeworks.songinfoscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.repositories.SongInfoRepository
import com.example.domain.models.SongInfo
import com.example.domain.usecases.GetSongfInfoById

class SongInfoViewModel:ViewModel() {
    private val getSongInfoById = GetSongfInfoById(SongInfoRepository())
    private val _songInfoListLiveData = MutableLiveData<SongInfo>()
    val songInfoListLiveData: LiveData<SongInfo> = _songInfoListLiveData
    fun getSongInfo(id:String){
        getSongInfoById(id,::updateSongInfo)
    }
    private fun updateSongInfo(data:SongInfo){
        _songInfoListLiveData.value=data
    }
}