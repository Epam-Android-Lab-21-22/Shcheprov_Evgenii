package com.example.shcheprov_homeworks.rightscreen.presenters

import com.example.shcheprov_homeworks.rightscreen.entities.RightScreenRecyclerViewItem

interface RightScreenContract {
    fun updateRecyclerView(list:List<RightScreenRecyclerViewItem>)
    fun showProgressBar()
}
