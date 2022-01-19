package com.example.shcheprov_homeworks.districtScreen.presenters


import com.example.shcheprov_homeworks.districtScreen.data.DistrictsRepository
import com.example.shcheprov_homeworks.districtScreen.entities.District

class DistrictPresenter(private var view: IDistrictView) {
    private val repository = DistrictsRepository()

    fun onButtonAddClicked() {
        view.startUpdating()
        repository.addItem(view::update)

    }

    fun onViewRestored(data: List<District>) {
        if (data.isNotEmpty())
            repository.setList(data)
        view.update(repository.getList())
    }

    fun onViewDestroyed(): List<District> {
        repository.cancelAddJob()
        return repository.getList()
    }
}




