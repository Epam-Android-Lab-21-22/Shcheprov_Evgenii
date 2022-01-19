package com.example.shcheprov_homeworks.districtScreen.view

import androidx.recyclerview.widget.DiffUtil
import com.example.shcheprov_homeworks.districtScreen.entities.District

class DistrictRecyclerViewDiffUtilCallBack(
    private val oldList: List<District>,
    private val newList: List<District>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].iconId == newList[newItemPosition].iconId &&
                oldList[oldItemPosition].textId == newList[newItemPosition].textId
    }


}