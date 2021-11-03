package com.akin.leagueoflegends.data.models.irelia

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class Champion(
    @SerializedName("data")
    val characterData: JsonObject,
    val format: String,
    val type: String,
    val version: String
)