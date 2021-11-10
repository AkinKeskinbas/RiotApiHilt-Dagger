package com.akin.leagueoflegends.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.akin.leagueoflegends.data.models.allcharacternameanddata.CharacterModel
import com.akin.leagueoflegends.data.models.characterlargedata.Character
import com.akin.leagueoflegends.interfaces.ITabbedFragment
import com.akin.leagueoflegends.interfaces.SendData
import com.akin.leagueoflegends.ui.fragment.DescFragment
import com.akin.leagueoflegends.ui.fragment.SkillsFragment
import com.akin.leagueoflegends.ui.fragment.SkinsFragment

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private var character: Character,

    ) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                SkinsFragment(character)
            }
            1 -> {
                SkillsFragment(character)

            }
            2 -> {
                DescFragment(character)
            }
            else -> {
                Fragment()
            }

        }
    }


}