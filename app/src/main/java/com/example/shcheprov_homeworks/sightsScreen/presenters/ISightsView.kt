package com.example.shcheprov_homeworks.sightsScreen.presenters

import com.example.shcheprov_homeworks.sightsScreen.entities.Sight

interface ISightsView {
    fun update(list: List<Sight>)
    fun showProgressBar()
}