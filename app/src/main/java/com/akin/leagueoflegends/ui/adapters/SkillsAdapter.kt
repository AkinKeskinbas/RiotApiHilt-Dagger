package com.akin.leagueoflegends.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akin.leagueoflegends.data.models.allcharacternameanddata.CharacterModel
import com.akin.leagueoflegends.data.models.characterlargedata.Character
import com.akin.leagueoflegends.databinding.SkillsItemBinding
import com.akin.leagueoflegends.databinding.SkinsItemBinding
import com.akin.leagueoflegends.util.loadString
import com.akin.leagueoflegends.util.makePlaceHolder

class SkillsAdapter( ) :
    RecyclerView.Adapter<SkillsAdapter.SkillsViewHolder>() {
    private var heroDataList: List<Character> = mutableListOf()
    private var heroImageList: List<String> = mutableListOf()

    class SkillsViewHolder(val binding: SkillsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillsViewHolder {
        val binding = SkillsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SkillsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SkillsViewHolder, position: Int) {
        holder.binding.apply {
            skillNameText.text =  heroDataList[0].spells[position].name
            skillText.text =  heroDataList[0].spells[position].description
            skillCostText.text =  heroDataList[0].spells[position].costBurn
            println(heroImageList[position])
            skillImage.loadString(heroImageList[position], makePlaceHolder(holder.itemView.context))
        }


    }

    override fun getItemCount(): Int {
        return heroImageList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun loadCollectionsData(data: List<Character>,images: List<String>) {
        this.heroDataList = data
        this.heroImageList = images
        notifyDataSetChanged()
    }
}