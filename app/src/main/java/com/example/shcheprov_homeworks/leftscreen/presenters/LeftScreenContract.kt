package com.example.shcheprov_homeworks.leftscreen.presenters

import com.example.shcheprov_homeworks.leftscreen.entities.LeftFragmentRecyclerViewItem

interface LeftScreenContract {
    fun updateRecyclerView(list: List<LeftFragmentRecyclerViewItem>)
    fun showProgressBar()
}