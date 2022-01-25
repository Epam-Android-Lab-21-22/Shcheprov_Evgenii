package com.example.shcheprov_homeworks.favoritesongsscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.data.repositories.SongPreviewRespsiotory
import com.example.domain.models.SongPreview
import com.example.domain.usecases.GetSongPreviewList

class FavoriteSongsViewModel: ViewModel() {
    private val _songPreviewListLiveData = MutableLiveData<List<SongPreview>>()
    val songPreviewListLiveData: LiveData<List<SongPreview>> = _songPreviewListLiveData

    fun getSongPreviewList(){
        val previewList = GetSongPreviewList(SongPreviewRespsiotory())
        previewList(::updateSongPreviewList)
    }
    private fun updateSongPreviewList(list:List<SongPreview>){
        _songPreviewListLiveData.value=list
    }
}