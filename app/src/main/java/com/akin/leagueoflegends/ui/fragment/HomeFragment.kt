package com.akin.leagueoflegends.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.akin.leagueoflegends.R
import com.akin.leagueoflegends.databinding.FragmentHomeBinding
import com.akin.leagueoflegends.domains.viewmodel.ChampionFragmentViewModel
import com.akin.leagueoflegends.ui.adapters.HomeAdapter
import com.akin.leagueoflegends.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private var imageList: MutableList<String> = mutableListOf()
    private var nameList: MutableList<String> = mutableListOf()
    private val viewModel: ChampionFragmentViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val gridLayoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        binding.rcHome.layoutManager = gridLayoutManager
        val rcHomeAdapter = HomeAdapter(clickListener = {
          val action =   HomeFragmentDirections.actionHomeFragmentToDetailFragment(it)
            findNavController().navigate(action)
        })
        binding.rcHome.adapter = rcHomeAdapter

        viewModel.championNameAndData.observe(viewLifecycleOwner, {

            for (characterModel in it) {

                val test2 = getChampionSquareImage(characterModel.id)
                imageList.add(test2)

            }
            rcHomeAdapter.loadCollectionsData(it,imageList)
            println(nameList)

        })



    }

    private fun getChampionSquareImage(name: String): String {

        return viewModel.getChampionSquareImage(name)

    }


}


