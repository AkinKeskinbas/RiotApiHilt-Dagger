package com.akin.leagueoflegends.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.akin.leagueoflegends.R
import com.akin.leagueoflegends.databinding.FragmentHomeBinding
import com.akin.leagueoflegends.domains.viewmodel.ChampionFragmentViewModel
import com.akin.leagueoflegends.ui.adapters.HomeAdapter
import com.akin.leagueoflegends.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private var imageList: MutableList<String> = mutableListOf()
    private var nameList: MutableList<String> = mutableListOf()
    private val viewModel: ChampionFragmentViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getChampion("Akali")

        val gridLayoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        binding.rcHome.layoutManager = gridLayoutManager
        val rcHomeAdapter = HomeAdapter()
        binding.rcHome.adapter = rcHomeAdapter

        viewModel.championNameAndData.observe(viewLifecycleOwner, {
            val re = Regex("[^A-Za-z0-9]")
            for (characterModel in it) {

                val test2 = getChampionSquareImage(characterModel.name.replace(re, ""))
                imageList.add(test2)
                nameList.add(characterModel.name)
            }
            rcHomeAdapter.loadCollectionsData(it,imageList)
            println(nameList)

        })
        viewModel.response.observe(viewLifecycleOwner, {
            println(it.enemytips)
            binding.apply {
                val test = getChampionNumber("Akali", "32")

                //  image.loadString(test, makePlaceHolder(this@MainActivity))
                // Glide.with(this@MainActivity).load(test).fitCenter().into(image)
            }
        })


    }
    private fun getChampion(name: String) {
        viewModel.getChampion(name)
    }

    private fun getChampionNumber(name: String, number: String): String {
        println("championNumberFunc")
        return viewModel.getChampionSkinNumbers(name, number)
    }

    private fun getChampionSquareImage(name: String): String {

        return viewModel.getChampionSquareImage(name)

    }


}


