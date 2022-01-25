package com.example.data.fakedb

import com.example.domain.models.SongInfo
import com.example.domain.models.SongPreview

object SongData {
    val data: Map<String, SongInfo> = mapOf(
        Pair(
            SongPreviewData.data[0].id,
            SongInfo(SongPreviewData.data[0], "2006", "Phobia", "Ню-метал", SongTexstsData.songTexts[0])
        ),
        Pair(
            SongPreviewData.data[1].id,
            SongInfo(SongPreviewData.data[1], "2008", "VII", "Металкор", SongTexstsData.songTexts[1])
        ),
        Pair(
            SongPreviewData.data[2].id,
            SongInfo(SongPreviewData.data[2], "2020", "After Hours", "R&B/cоул, Синтвейв", SongTexstsData.songTexts[2])
        ),
        Pair(
            SongPreviewData.data[3].id,
            SongInfo(SongPreviewData.data[3], "2020", "Nectar", "Альтернативная музыка/инди", SongTexstsData.songTexts[3])
        ),
        Pair(
            SongPreviewData.data[4].id,
            SongInfo(SongPreviewData.data[4], "2009", "Саундтрек Моей Жизни", "Метал", SongTexstsData.songTexts[4])
        ),
        Pair(
            SongPreviewData.data[5].id,
            SongInfo(SongPreviewData.data[5], "1999", "Ели мясо мужики", "Хоррор-панк", SongTexstsData.songTexts[5])
        ),
        Pair(
            SongPreviewData.data[6].id,
            SongInfo(SongPreviewData.data[6], "2006", "Трудный возраст", "Поп", SongTexstsData.songTexts[6])
        ),
        Pair(
            SongPreviewData.data[7].id,
            SongInfo(SongPreviewData.data[7], "1990", "Crazy World", "Хард-рок", SongTexstsData.songTexts[7])
        ),
        Pair(
            SongPreviewData.data[8].id,
            SongInfo(SongPreviewData.data[8], "2000", "Hybrid Theory", "Альтернативный рок,ню-метал", SongTexstsData.songTexts[8])
        ),
        Pair(
            SongPreviewData.data[9].id,
            SongInfo(SongPreviewData.data[9], "1991", "Metallica", "Хеви-метал,хард-рок", SongTexstsData.songTexts[9])
        ),
        Pair(
            SongPreviewData.data[10].id,
            SongInfo(SongPreviewData.data[10], "2019", "Hollywood’s Bleeding", "Рок-музыка, трэп, хип-хоп/рэп", SongTexstsData.songTexts[10])
        ),
        Pair(
            SongPreviewData.data[11].id,
            SongInfo(SongPreviewData.data[11], "2004", "American Idiot", "Панк-рок", SongTexstsData.songTexts[11])
        ),
        Pair(
            SongPreviewData.data[12].id,
            SongInfo(SongPreviewData.data[12], "1967", "сингл", "Поп", SongTexstsData.songTexts[12])
        ),
        Pair(
            SongPreviewData.data[13].id,
            SongInfo(SongPreviewData.data[13], "2006", "Comatose", "Прогрессивный метал, Рок", SongTexstsData.songTexts[13])
        ),
    )
    val defaultSongData = SongInfo(
        SongPreview("unknown", "unknown", "unknown", null),
        "unknown",
        "unknown",
        "unknown",
        "unknown"
    )

}