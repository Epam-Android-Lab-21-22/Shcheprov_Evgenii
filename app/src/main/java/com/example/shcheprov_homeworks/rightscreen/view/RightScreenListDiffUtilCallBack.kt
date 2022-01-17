package com.example.shcheprov_homeworks.rightscreen.view

import androidx.recyclerview.widget.DiffUtil
import com.example.shcheprov_homeworks.rightscreen.entities.RightScreenRecyclerViewItem

class RightScreenListDiffUtilCallBack(
    private val oldList: List<RightScreenRecyclerViewItem>,
    private val newList: List<RightScreenRecyclerViewItem>,
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