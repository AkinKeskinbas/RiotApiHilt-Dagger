package com.akin.leagueoflegends.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.akin.leagueoflegends.data.models.characterlargedata.Character
import com.akin.leagueoflegends.databinding.FragmentSkinsBinding
import com.akin.leagueoflegends.domains.viewmodel.ChampionFragmentViewModel
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
            list.add( viewModel.getChampionImageWithSkinNumbers(type = BASE_IMAGE_URL,championName = character.id, championSkinNumber = it.num.toString()))

        }
        adapter.loadCollectionsData(list)
    }


}