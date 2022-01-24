package com.example.shcheprov_homeworks.favoritesongsscreen

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.SongPreview

class SongsPreviewListDiffUtils(
    private val oldList: List<SongPreview>,
    private val newList: List<SongPreview>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].coverUrl == newList[newItemPosition].coverUrl &&
                oldList[oldItemPosition].performer == newList[newItemPosition].performer&&
                oldList[oldItemPosition].title== newList[newItemPosition].title
    }


}