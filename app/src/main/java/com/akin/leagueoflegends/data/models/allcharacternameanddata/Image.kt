package com.akin.leagueoflegends.data.models.allcharacternameanddata

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val full: String,
    val group: String,
    val h: Int,
    val sprite: String,
    val w: Int,
    val x: Int,
    val y: Int
):Parcelable