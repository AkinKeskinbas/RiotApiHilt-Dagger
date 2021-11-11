package com.akin.leagueoflegends.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.akin.leagueoflegends.R
import com.akin.leagueoflegends.data.models.characterlargedata.Character
import com.akin.leagueoflegends.databinding.FragmentDetailBinding
import com.akin.leagueoflegends.domains.viewmodel.ChampionFragmentViewModel
import com.akin.leagueoflegends.interfaces.ITabbedFragment
import com.akin.leagueoflegends.interfaces.SendData
import com.akin.leagueoflegends.ui.adapters.ViewPagerAdapter
import com.akin.leagueoflegends.ui.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val viewModel: ChampionFragmentViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var viewPager2: ViewPager2
    private lateinit var character: Character

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println(args.characterModel.id)

        viewModel.getChampion(args.characterModel.id)

        viewModel.response.observe(viewLifecycleOwner, {
            character = it
            setTabLayout()

        })

    }

//    private fun getChampionNumber(name: String, number: String): String {
//        println("championNumberFunc")
//        return viewModel.getChampionSkinNumbers(name, number)
//    }

    private fun setTabLayout() {

        val tabLayout = binding.tabLayout
        viewPager2 = binding.viewPager2
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle, character)
        viewPager2.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Skins"

                }
                1 -> {
                    tab.text = "Skills"
                }
                2 -> {
                    tab.text = "Description"
                }
            }
        }.attach()
    }


}