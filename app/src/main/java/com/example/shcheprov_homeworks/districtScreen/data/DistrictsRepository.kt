package com.example.shcheprov_homeworks.districtScreen.data

import android.util.Log
import com.example.shcheprov_homeworks.districtScreen.entities.District
import kotlinx.coroutines.*
import kotlin.random.Random

class DistrictsRepository {

    private val data: MutableList<District> = mutableListOf()
    private var addJob: Job? = null

    fun getList(): List<District> = data
    fun setList(data: List<District>) {
        this.data.clear()
        this.data.addAll(data)
    }

    fun addItem(callback: (List<District>) -> Unit) {
        if (!isAddJobActive()) {
            addJob = CoroutineScope(Dispatchers.IO).launch {
                delay(1000)
                val image = DistrictsData.imageList
                val phrase = DistrictsData.phrasesList
                data.add(
                    District(
                        image[Random.nextInt(image.size)],
                        phrase[Random.nextInt(phrase.size)]
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