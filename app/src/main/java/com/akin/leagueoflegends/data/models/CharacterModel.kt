package com.akin.leagueoflegends.data.models

data class CharacterModel(
    val blurb: String,
    val id: String,
    val image: Image,
    val info: Info,
    val key: String,
    val name: String,
    val partype: String,
    val stats: Stats,
    val tags: List<String>,
    val title: String,
    val version: String
)