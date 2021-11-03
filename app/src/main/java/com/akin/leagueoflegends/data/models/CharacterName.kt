package com.akin.leagueoflegends.data.models

import com.google.gson.JsonObject


data class CharacterName(
    val `data`: JsonObject,
    val format: String,
    val type: String,
    val version: String
)