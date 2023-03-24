package com.app.instagramfeed.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.instagramfeed.databinding.SearchIcBinding

class GridAdapter : RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SearchIcBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.apply {
            tv.text = position.toString()
        }
    }

    override fun getItemCount(): Int = 15


    inner class ViewHolder(val binding: SearchIcBinding) :
        RecyclerView.ViewHolder(binding.root)
}