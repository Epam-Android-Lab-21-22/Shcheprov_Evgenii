package com.example.shcheprov_homeworks.leftscreen.data


import com.example.shcheprov_homeworks.leftscreen.entities.LeftFragmentRecyclerViewItem
import kotlinx.coroutines.*

class LeftScreenListRepository {
    private val data: MutableList<LeftFragmentRecyclerViewItem> = mutableListOf()
    private var deleteJob: Job? = null

    init {
        data.addAll(LeftScreenLists.leftListExample)
    }

    fun getList(): List<LeftFragmentRecyclerViewItem> {
        return data
    }

    fun deleteItem(position: Int, callback: (List<LeftFragmentRecyclerViewItem>) -> Unit) {
        if (!isDeleteJobActive()) {
            deleteJob = CoroutineScope(Dispatchers.IO).launch {
                delay(2000)
                data.removeAt(position)
                CoroutineScope(Dispatchers.Main).launch { callback(data) }
            }
        }
    }

    private fun isDeleteJobActive(): Boolean = deleteJob?.isActive ?: false
    fun cancelDeleteJob() {
        if (isDeleteJobActive())
            deleteJob?.cancel()
    }

}