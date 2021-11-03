package com.akin.leagueoflegends.data.api

import com.akin.leagueoflegends.data.models.CharacterName
import com.akin.leagueoflegends.data.models.Data
import com.akin.leagueoflegends.data.models.irelia.Champion
import com.akin.leagueoflegends.data.models.irelia.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("11.22.1/data/tr_TR/champion/{championName}.json")
    suspend fun getChampion(@Path("championName") championName: String): Response<Champion>

    @GET("11.22.1/data/tr_TR/champion/img/champion/loading/{championName}_{skinNumber}.jpg")
    suspend fun getChampionImage(
        @Path("championName") championName: String,
        @Path("skinNumber") skinNumber: String
    ): Response<Champion>
    @GET("11.22.1/data/tr_TR/champion.json")
    suspend fun getChampionNames():Response<CharacterName>
}