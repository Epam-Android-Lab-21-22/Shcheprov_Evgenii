package com.example.shcheprov_homeworks.sightsScreen.data


import com.example.shcheprov_homeworks.sightsScreen.entities.Sight

import com.example.shcheprov_homeworks.sightsScreen.entities.SightsType

object SightsData {
    val sightsListExample = listOf(
        Sight("по желанию", SightsType.TYPE_TITLE),
        Sight("Государственный банк", SightsType.TYPE_OPTIONAL),
        Sight("улица Рождественская", SightsType.TYPE_OPTIONAL),
        Sight("Стадион", SightsType.TYPE_OPTIONAL),
        Sight("Соборная мечеть", SightsType.TYPE_OPTIONAL),
        Sight("канатная дорога", SightsType.TYPE_OPTIONAL),
        Sight("обязательно к посещению", SightsType.TYPE_TITLE),
        Sight("Кремль", SightsType.TYPE_REQUIRED),
        Sight("Набережна Федоровского", SightsType.TYPE_REQUIRED),
        Sight("Чкаловская лестница", SightsType.TYPE_REQUIRED),
        Sight("Большая Покровская", SightsType.TYPE_REQUIRED),
        Sight("Нижне-Волжская набережная", SightsType.TYPE_REQUIRED)
    )
}