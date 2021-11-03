package com.akin.leagueoflegends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import com.akin.leagueoflegends.databinding.ActivityMainBinding
import com.akin.leagueoflegends.domains.viewmodel.ChampionFragmentViewModel
import com.akin.leagueoflegends.util.Statics.BASE_URL
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var list: List<String>
    private val viewModel: ChampionFragmentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getChampion("Irelia")

        viewModel.championNameAndData.observe(this,{
            println(it.size)
        })
        viewModel.response.observe(this,{
            println(it.enemytips)
        })







    }

      fun  getChampion(name:String) {
        viewModel.getChampion(name)
    }
    fun  getChampionNumber(name:String, number:String) {
        println("championNumberFunc")
        viewModel.getChampionSkinNumbers(name,number)
    }




}