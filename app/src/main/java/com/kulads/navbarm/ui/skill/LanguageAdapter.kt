package com.kulads.navbarm.ui.skill

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LanguageAdapter(var myList: List<LanguageData>) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val logo : ImageView = itemView.findViewById(R.id.logoIv)
        val tittleTv : TextView = itemView.findViewById(R.id.titleTv)
    }

    fun setFilterList(myList: List<LanguageData>){
        this.myList = myList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item , parent , false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.logo.setImageResource(myList[position].logo)
        holder.tittleTv.text = myList[position].title
    }
}