package com.akin.leagueoflegends.domains.repository

import com.akin.leagueoflegends.data.api.RetrofitService
import javax.inject.Inject

class ChampionRepository
@Inject
constructor(private val apiService: RetrofitService) {

    suspend fun getChampion(championName: String) = apiService.getChampion(championName)

    suspend fun getCharacterNames() = apiService.getChampionNames()
}