package com.akin.leagueoflegends.domains.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akin.leagueoflegends.data.models.CharacterModel
import com.akin.leagueoflegends.data.models.irelia.Character
import com.akin.leagueoflegends.domains.repository.ChampionRepository
import com.akin.leagueoflegends.util.Statics.BASE_IMAGE_URL
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import org.json.JSONObject
import javax.inject.Inject
import android.widget.Toast
import com.google.gson.*


@HiltViewModel
class ChampionFragmentViewModel
@Inject
constructor(
    private val repository: ChampionRepository,

    ) :
    ViewModel() {

    private val _response = MutableLiveData<Character>()
    val response: LiveData<Character> = _response

    private val _championSkinNumbers = mutableListOf<String>()
    val championSkinNumbers: List<String> = _championSkinNumbers

    private val _championNameAndData = MutableLiveData<List<CharacterModel>>()
    val championNameAndData: LiveData<List<CharacterModel>> = _championNameAndData

    lateinit var test: LiveData<Deferred<String>>

    init {

        getChampionNames()
    }

    fun getChampion(championName: String) = viewModelScope.launch {
        repository.getChampion(championName).let { response ->

            if (response.isSuccessful) {
                val gson = Gson()
                val gsonString = gson.toJson(response.body()!!.characterData).toString()
                val obj = JsonParser().parse(gsonString).asJsonObject[championName]
                val teta = gson.fromJson(obj, Character::class.java)


                _response.postValue(teta)
                teta.skins.forEach {
                    _championSkinNumbers.add(it.num.toString())
                }

                println("listelemebitti:::${championSkinNumbers}")



            } else {
                Log.d("Tag", "Error:${response.message()}")
            }
        }
    }

    fun getChampionSkinNumbers(championName: String, championSkinNumber: String): String {

        println(BASE_IMAGE_URL + "${championName}_${championSkinNumber}.jpg")
        return BASE_IMAGE_URL + "${championName}_${championSkinNumber}.jpg"
    }

    fun getChampionNames() {
        viewModelScope.launch {
            val test = repository.getCharacterNames().let { response ->
                println(response)
                if (response.isSuccessful) {
                    val gson = Gson()
                    val gsonString = gson.toJson(response.body()).toString()
                    val obj = JsonParser().parse(gsonString).asJsonObject["data"]
                    println(obj.asJsonObject.keySet())
                    val list = mutableListOf<CharacterModel>()
                    val beta = obj.asJsonObject.keySet()
                    beta.forEach {
                        val teta = gson.fromJson(obj.asJsonObject[it], CharacterModel::class.java)
                        list.add(teta)

                    }
                    _championNameAndData.value = list


                } else {
                    println(response.message())
                }
            }

        }

    }

}