package com.akin.leagueoflegends.data.models.characterlargedata

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class Champion(
    @SerializedName("data")
    val characterData: JsonObject,
    val format: String,
    val type: String,
    val version: String
)