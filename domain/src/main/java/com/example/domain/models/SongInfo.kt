package com.example.domain.models

data class SongInfo(val songPreview: SongPreview,
                    val release:String,
                    val album:String,
                    val genre:String,
                    val text:String)