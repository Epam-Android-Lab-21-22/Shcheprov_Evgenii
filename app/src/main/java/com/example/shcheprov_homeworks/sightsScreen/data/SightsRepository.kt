package com.example.shcheprov_homeworks.sightsScreen.data


import com.example.shcheprov_homeworks.sightsScreen.entities.Sight
import kotlinx.coroutines.*

class SightsRepository {
    private val data: MutableList<Sight> = mutableListOf()
    private var deleteJob: Job? = null

    init {
        data.addAll(SightsData.sightsListExample)
    }

    fun getList(): List<Sight> {
        return data
    }

    fun setList(data: List<Sight>) {
        this.data.clear()
        this.data.addAll(data)
    }

    fun deleteItem(position: Int, callback: (List<Sight>) -> Unit) {
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