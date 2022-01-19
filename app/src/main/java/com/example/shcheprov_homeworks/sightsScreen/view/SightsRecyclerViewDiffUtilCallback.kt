package com.example.shcheprov_homeworks.sightsScreen.view

import androidx.recyclerview.widget.DiffUtil
import com.example.shcheprov_homeworks.sightsScreen.entities.Sight

class SightsRecyclerViewDiffUtilCallback(
    private val oldList: List<Sight>,
    private val newList: List<Sight>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].text == newList[newItemPosition].text &&
                oldList[oldItemPosition].type == newList[newItemPosition].type
    }
}