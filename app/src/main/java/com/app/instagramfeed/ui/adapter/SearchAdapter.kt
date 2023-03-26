package com.app.instagramfeed.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.app.instagramfeed.databinding.SearchIcBinding

class GridAdapter(
    private val items: MutableList<Int>,
) :
    RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    var isLeft = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SearchIcBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val params = holder.binding.tv.layoutParams as ConstraintLayout.LayoutParams
        var item = items[position]

        if (position % 3 == 0) {
            if (isLeft) {
                params.dimensionRatio = "0.8"
            }
            item = items[position]
            isLeft = !isLeft

        } else if (position % 3 == 1) {

            if (isLeft) {
                item = items[position + 1]
                params.dimensionRatio = "0.8"
            }

        } else if (position % 3 == 2) {
            if (isLeft) {
                item = items[position - 1]
            }
        }

        holder.binding.tv.layoutParams = params

        holder.binding.apply {
            tv.text = item.toString()
        }

    }

    override fun getItemCount(): Int = items.size
    fun addData(item: List<Int>) {
        val oldSize = items.size
        items.addAll(item)
        notifyItemRangeInserted(oldSize, item.size)
    }

    inner class ViewHolder(val binding: SearchIcBinding) :
        RecyclerView.ViewHolder(binding.root)
}