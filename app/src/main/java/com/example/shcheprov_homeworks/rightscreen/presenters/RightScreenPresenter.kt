package com.example.shcheprov_homeworks.rightscreen.presenters


import com.example.shcheprov_homeworks.rightscreen.data.RightScreenListRepository

class RightScreenPresenter(private var _view: RightScreenContract?) {
    private val view get() = _view!!
    private val repository = RightScreenListRepository()

    fun onButtonAddClicked() {
        view.showProgressBar()
        repository.addItem(view::updateRecyclerView)
    }
    fun onViewCreated(view:RightScreenContract){
        _view=view
        view.updateRecyclerView(repository.getList())
    }

    fun onViewDestroyed() {
        repository.cancelAddJob()
        _view = null
    }
}




