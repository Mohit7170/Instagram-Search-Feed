package com.app.instagramfeed.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.instagramfeed.R
import com.app.instagramfeed.databinding.SearchIcBinding

class GridAdapter(
    private val activity: Activity,
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

        val params = holder.binding.tv.layoutParams
        var item = items[position]

        if (position % 3 == 0) {
            params.height =
                activity.resources.getDimensionPixelSize(if (isLeft) R.dimen._120dp else R.dimen._60dp)
            isLeft = !isLeft

            item = items[position]

        } else if (position % 3 == 1) {

            params.height =
                activity.resources.getDimensionPixelSize(if (isLeft) R.dimen._120dp else R.dimen._60dp)

            if (isLeft) {
                item = items[position + 1]
            }
        } else if (position % 3 == 2) {
            params.height = activity.resources.getDimensionPixelSize(R.dimen._60dp)

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