package com.example.shcheprov_homeworks.rightscreen.data

import com.example.shcheprov_homeworks.rightscreen.entities.RightScreenRecyclerViewItem
import kotlinx.coroutines.*
import kotlin.random.Random

class RightScreenListRepository {

    private val data: MutableList<RightScreenRecyclerViewItem> = mutableListOf()
    private var addJob: Job? = null

    fun getList(): List<RightScreenRecyclerViewItem> {
        return data
    }
    fun addItem(callback: (List<RightScreenRecyclerViewItem>) -> Unit) {
        if (!isAddJobActive()) {
            addJob = CoroutineScope(Dispatchers.IO).launch {
                delay(1000)
                val image = RightScreenLists.list
                val str = RightScreenLists.phrasesList
                data.add(
                    RightScreenRecyclerViewItem(
                        image[Random.nextInt(image.size)],
                        str[Random.nextInt(str.size)]
                    )
                )
                CoroutineScope(Dispatchers.Main).launch { callback(data) }
            }
        }
    }

    private fun isAddJobActive(): Boolean = addJob?.isActive ?: false

    fun cancelAddJob() {
        if (isAddJobActive())
            addJob?.cancel()
    }

}