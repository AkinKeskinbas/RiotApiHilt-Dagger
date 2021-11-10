package com.akin.leagueoflegends.interfaces

import androidx.fragment.app.Fragment
import com.akin.leagueoflegends.data.models.characterlargedata.Character

interface SendData {
    fun sendData(data:Character,fragment:Fragment)
}