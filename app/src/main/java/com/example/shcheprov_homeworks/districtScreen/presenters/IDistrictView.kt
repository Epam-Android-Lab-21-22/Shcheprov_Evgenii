package com.example.shcheprov_homeworks.districtScreen.presenters

import com.example.shcheprov_homeworks.districtScreen.entities.District

interface IDistrictView {
    fun update(list:List<District>)
    fun startUpdating()
}
