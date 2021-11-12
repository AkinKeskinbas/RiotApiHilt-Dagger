package com.akin.leagueoflegends.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.akin.leagueoflegends.data.models.characterlargedata.Character
import com.akin.leagueoflegends.databinding.FragmentDescBinding
import com.akin.leagueoflegends.domains.viewmodel.ChampionFragmentViewModel
import com.akin.leagueoflegends.ui.base.BaseFragment
import com.akin.leagueoflegends.util.Statics.BASE_SPLASH_URL
import com.akin.leagueoflegends.util.loadString
import com.akin.leagueoflegends.util.makePlaceHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class DescFragment(private var character: Character) :
    BaseFragment<FragmentDescBinding>(FragmentDescBinding::inflate) {


    var list = mutableListOf<String>()
    private val viewModel: ChampionFragmentViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            descText.text = character.lore
            allyText.text = character.allytips.joinToString()
            enemyText.text = character.enemytips.joinToString()
            descImage.loadString(getImage(), makePlaceHolder(requireContext()))
        }

    }

    private fun getImage(): String {
        character.skins.forEach {
            list.add(
                viewModel.getChampionImageWithSkinNumbers(
                    type = BASE_SPLASH_URL,
                    championName = character.id,
                    championSkinNumber = it.num.toString()
                )
            )
        }
        val rand = Random.nextInt(0, list.size)
        return list[rand]
    }


}