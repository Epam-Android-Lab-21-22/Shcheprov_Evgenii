package com.example.shcheprov_homeworks.leftscreen.presenters

import com.example.shcheprov_homeworks.leftscreen.data.LeftScreenListRepository


class LeftScreenPresenter(private var _view: LeftScreenContract?) {
    private val view get() = _view!!
    private val repository = LeftScreenListRepository()

    fun onButtonDeleteClicked(position: Int) {
        view.showProgressBar()
        repository.deleteItem(position, view::updateRecyclerView)
    }

    fun onViewCreated(view: LeftScreenContract) {
        _view = view
        view.updateRecyclerView(repository.getList())
    }

    fun onViewDestroyed() {
        repository.cancelDeleteJob()
        _view = null
    }
}
