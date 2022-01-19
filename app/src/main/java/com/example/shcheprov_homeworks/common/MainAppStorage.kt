package com.example.shcheprov_homeworks.common

import com.example.shcheprov_homeworks.districtScreen.entities.District
import com.example.shcheprov_homeworks.sightsScreen.entities.Sight

class MainAppStorage {
    private var districtList: MutableList<District>? = null
    private var sightsList: MutableList<Sight>? = null
    fun initialize() {
        districtList = mutableListOf()
        sightsList = mutableListOf()
    }

    fun setDistrictData(data: List<District>) {
        districtList?.clear()
        districtList?.addAll(data)
    }

    fun getDistrictData() = districtList

    fun setSightsData(data: List<Sight>) {
        sightsList?.clear()
        sightsList?.addAll(data)
    }

    fun getSightsData() = sightsList
}