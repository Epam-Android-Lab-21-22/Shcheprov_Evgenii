package com.example.shcheprov_homeworks.sightsScreen.presenters

import com.example.shcheprov_homeworks.sightsScreen.data.SightsRepository
import com.example.shcheprov_homeworks.sightsScreen.entities.Sight


class SightsPresenter(private var view: ISightsView) {

    private val repository = SightsRepository()

    fun onButtonDeleteClicked(position: Int) {
        view.showProgressBar()
        repository.deleteItem(position, view::update)
    }

    fun onViewRestored(data:List<Sight>){
        if(data.isNotEmpty())
        repository.setList(data)
        view.update(repository.getList())
    }
    fun onViewDestroyed(): List<Sight> {
        repository.cancelDeleteJob()
        return repository.getList()
    }
}
