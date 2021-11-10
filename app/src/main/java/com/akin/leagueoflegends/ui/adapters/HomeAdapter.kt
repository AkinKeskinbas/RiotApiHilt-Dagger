package com.akin.leagueoflegends.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.akin.leagueoflegends.data.models.allcharacternameanddata.CharacterModel
import com.akin.leagueoflegends.databinding.FragmentHomeBinding
import com.akin.leagueoflegends.databinding.HomeItemBinding
import com.akin.leagueoflegends.util.loadString
import com.akin.leagueoflegends.util.makePlaceHolder

class HomeAdapter(var clickListener: (data: CharacterModel) -> Unit = {}) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private var heroList: List<CharacterModel> = mutableListOf()
    private var heroImageList: List<String> = mutableListOf()

    class HomeViewHolder(val binding: HomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        val binding =
            HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        holder.binding.apply {
            val positionedHeroList = heroList[position]
            val positionedHeroImageList = heroImageList[position]
            nameText.text = positionedHeroList.name
            imageHome.loadString(positionedHeroImageList, makePlaceHolder(holder.itemView.context))
            imageHome.setOnClickListener {
                clickListener(positionedHeroList)

            }
        }
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun loadCollectionsData(items: List<CharacterModel>, images: List<String>) {
        this.heroList = items
        this.heroImageList = images
        notifyDataSetChanged()
    }
}