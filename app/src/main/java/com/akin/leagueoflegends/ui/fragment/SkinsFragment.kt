package com.akin.leagueoflegends.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.akin.leagueoflegends.R
import com.akin.leagueoflegends.data.models.characterlargedata.Character
import com.akin.leagueoflegends.databinding.FragmentSkinsBinding
import com.akin.leagueoflegends.domains.viewmodel.ChampionFragmentViewModel
import com.akin.leagueoflegends.interfaces.ITabbedFragment
import com.akin.leagueoflegends.interfaces.SendData
import com.akin.leagueoflegends.ui.adapters.SkinsAdapter
import com.akin.leagueoflegends.ui.base.BaseFragment
import com.akin.leagueoflegends.util.Statics.BASE_IMAGE_URL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SkinsFragment(private var character: Character) : BaseFragment<FragmentSkinsBinding>(FragmentSkinsBinding::inflate) {

    private val viewModel: ChampionFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = mutableListOf<String>()
        val adapter = SkinsAdapter()
        val rc = binding.rcSkins
        rc.adapter = adapter
        character.skins.forEach {
            list.add( viewModel.getChampionSkinNumbers(type = BASE_IMAGE_URL,championName = character.id, championSkinNumber = it.num.toString()))
            println(viewModel.getChampionSkinNumbers(BASE_IMAGE_URL,character.id,it.num.toString()))


        }

        adapter.loadCollectionsData(list)
        println(character.skins[0])
    }


}