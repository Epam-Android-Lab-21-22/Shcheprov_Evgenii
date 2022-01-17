package com.example.shcheprov_homeworks.leftscreen.view

import androidx.recyclerview.widget.DiffUtil
import com.example.shcheprov_homeworks.leftscreen.entities.LeftFragmentRecyclerViewItem

class LeftScreenListDiffUtilCallback(
    private val oldList: List<LeftFragmentRecyclerViewItem>,
    private val newList: List<LeftFragmentRecyclerViewItem>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].text == newList[newItemPosition].text &&
                oldList[oldItemPosition].viewType == newList[newItemPosition].viewType
    }
}