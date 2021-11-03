package com.akin.leagueoflegends

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import com.akin.leagueoflegends.databinding.ActivityMainBinding
import com.akin.leagueoflegends.domains.viewmodel.ChampionFragmentViewModel
import com.akin.leagueoflegends.util.Statics.BASE_URL
import com.akin.leagueoflegends.util.loadString
import com.akin.leagueoflegends.util.makePlaceHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
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

        getChampion("Akali")

        viewModel.championNameAndData.observe(this,{
            println(it.size)
        })
        viewModel.response.observe(this,{
            println(it.enemytips)
            binding.apply {
                val test = getChampionNumber("Akali","32")
                println("test::${test}")
                image.loadString(test, makePlaceHolder(this@MainActivity))
              // Glide.with(this@MainActivity).load(test).fitCenter().into(image)
            }
        })







    }

      fun  getChampion(name:String) {
        viewModel.getChampion(name)
    }
    fun  getChampionNumber(name:String, number:String):String {
        println("championNumberFunc")
     return   viewModel.getChampionSkinNumbers(name,number)
    }




}