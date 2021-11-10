package com.akin.leagueoflegends.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akin.leagueoflegends.R
import com.akin.leagueoflegends.data.models.characterlargedata.Character
import com.akin.leagueoflegends.databinding.FragmentDescBinding
import com.akin.leagueoflegends.ui.base.BaseFragment


class DescFragment(private var character: Character) : BaseFragment<FragmentDescBinding>(FragmentDescBinding::inflate) {




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println(character.info)

    }


}