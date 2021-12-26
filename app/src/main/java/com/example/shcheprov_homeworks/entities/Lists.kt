package com.example.shcheprov_homeworks.entities

import com.example.shcheprov_homeworks.LeftFragmentRecyclerViewItem

object Lists {
    val listLeft = listOf(
        LeftFragmentRecyclerViewItem("удаляемый текст", leftItemViewType.TYPE_TITLE_ITEM),
        LeftFragmentRecyclerViewItem("строка 1", leftItemViewType.TYPE_REMOVABLE_ITEM),
        LeftFragmentRecyclerViewItem("строка 2", leftItemViewType.TYPE_REMOVABLE_ITEM),
        LeftFragmentRecyclerViewItem("строка 3", leftItemViewType.TYPE_REMOVABLE_ITEM),
        LeftFragmentRecyclerViewItem("строка 4", leftItemViewType.TYPE_REMOVABLE_ITEM),
        LeftFragmentRecyclerViewItem("строка 5", leftItemViewType.TYPE_REMOVABLE_ITEM),
        LeftFragmentRecyclerViewItem("неудаляемый текст", leftItemViewType.TYPE_TITLE_ITEM),
        LeftFragmentRecyclerViewItem("строка 6", leftItemViewType.TYPE_DEFAULT_ITEM),
        LeftFragmentRecyclerViewItem("строка 7", leftItemViewType.TYPE_DEFAULT_ITEM),
        LeftFragmentRecyclerViewItem("строка 8", leftItemViewType.TYPE_DEFAULT_ITEM),
        LeftFragmentRecyclerViewItem("строка 9", leftItemViewType.TYPE_DEFAULT_ITEM),
        LeftFragmentRecyclerViewItem("строка 10", leftItemViewType.TYPE_DEFAULT_ITEM)
    )


}