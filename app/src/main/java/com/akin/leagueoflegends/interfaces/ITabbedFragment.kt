package com.akin.leagueoflegends.interfaces

import com.akin.leagueoflegends.data.models.characterlargedata.Character

interface ITabbedFragment {
    fun onReceive(data:Character)
}