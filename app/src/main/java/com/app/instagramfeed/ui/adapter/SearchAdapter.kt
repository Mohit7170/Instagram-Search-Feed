package com.app.instagramfeed.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.instagramfeed.R
import com.app.instagramfeed.databinding.SearchIcBinding

class GridAdapter(private val activity: Activity, private val recyclerView: RecyclerView) :
    RecyclerView.Adapter<GridAdapter.ViewHolder>() {

    var items = 30
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


//        if (position % 3 == 0) {
//            val params = holder.binding.tv.layoutParams
//            params.height = activity.resources.getDimensionPixelSize(R.dimen._60dp)
//            holder.binding.tv.layoutParams = params
//        } else {
//            val params = holder.binding.tv.layoutParams
//            params.height = activity.resources.getDimensionPixelSize(R.dimen._120dp)
//            holder.binding.tv.layoutParams = params
//        }
        if (position % 3 == 0) {
            val params = holder.binding.tv.layoutParams
            params.height = activity.resources.getDimensionPixelSize(R.dimen._120dp)
            holder.binding.tv.layoutParams = params

        } else if (position % 3 == 1) {
            val params = holder.binding.tv.layoutParams
            params.height = activity.resources.getDimensionPixelSize(R.dimen._60dp)
            holder.binding.tv.layoutParams = params
        } else if (position % 3 == 2) {
            val params = holder.binding.tv.layoutParams
            params.height = activity.resources.getDimensionPixelSize(R.dimen._60dp)
            holder.binding.tv.layoutParams = params
        }


//        if (position == items - 1) {
//            addData(10)
//            return
//        }

        holder.binding.apply {
            tv.text = (position + 1).toString()
        }
    }

    override fun getItemCount(): Int = items

    private fun addData(item: Int) {

        val oldItem = items
        items += item

        recyclerView.post {
            notifyItemRangeInserted(oldItem, item)
        }

    }

    inner class ViewHolder(val binding: SearchIcBinding) :
        RecyclerView.ViewHolder(binding.root)
}