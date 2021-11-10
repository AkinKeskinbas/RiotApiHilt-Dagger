package com.akin.leagueoflegends.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akin.leagueoflegends.data.models.allcharacternameanddata.CharacterModel
import com.akin.leagueoflegends.databinding.SkinsItemBinding
import com.akin.leagueoflegends.util.loadString
import com.akin.leagueoflegends.util.makePlaceHolder

class SkinsAdapter( ) :
    RecyclerView.Adapter<SkinsAdapter.SkinsViewHolder>() {
    private var heroImageList: List<String> = mutableListOf()

    class SkinsViewHolder(val binding: SkinsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkinsViewHolder {
        val binding = SkinsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SkinsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SkinsViewHolder, position: Int) {
        println(holder.binding.skinImage.toString())
        holder.binding.skinImage.loadString(
            heroImageList[position],
            makePlaceHolder(holder.itemView.context)
        )

    }

    override fun getItemCount(): Int {
        return heroImageList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun loadCollectionsData(images: List<String>) {
        this.heroImageList = images
        notifyDataSetChanged()
    }
}