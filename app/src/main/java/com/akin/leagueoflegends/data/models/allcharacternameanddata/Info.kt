package com.akin.leagueoflegends.data.models.allcharacternameanddata

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(
    val attack: Int,
    val defense: Int,
    val difficulty: Int,
    val magic: Int
):Parcelable