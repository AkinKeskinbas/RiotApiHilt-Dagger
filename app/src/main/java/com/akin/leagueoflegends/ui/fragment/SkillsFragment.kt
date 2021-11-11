package com.akin.leagueoflegends.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.akin.leagueoflegends.R
import com.akin.leagueoflegends.data.models.characterlargedata.Character
import com.akin.leagueoflegends.databinding.FragmentSkillsBinding
import com.akin.leagueoflegends.databinding.FragmentSkinsBinding
import com.akin.leagueoflegends.domains.viewmodel.ChampionFragmentViewModel
import com.akin.leagueoflegends.interfaces.ITabbedFragment
import com.akin.leagueoflegends.ui.adapters.SkillsAdapter
import com.akin.leagueoflegends.ui.base.BaseFragment
import com.akin.leagueoflegends.util.Statics.BASE_SKILL_URL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SkillsFragment(private var character: Character) : BaseFragment<FragmentSkillsBinding>(FragmentSkillsBinding::inflate) {
    private val viewModel: ChampionFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println(character.spells[0])
        val list = mutableListOf<String>()
        val adapter = SkillsAdapter()
        val rcSkills = binding.rcSkills
        rcSkills.adapter = adapter

        character.spells.forEach {
         list.add(viewModel.getChampionSkillImages(type = BASE_SKILL_URL, skillName = it.id))

        }
        //println(list)

        adapter.loadCollectionsData(listOf(character),list)

    }

}