package com.app.instagramfeed.ui.adapter

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.instagramfeed.R
import com.app.instagramfeed.databinding.SearchIcBinding

class GridAdapter(
    private val activity: Activity,
    private val recyclerView: RecyclerView,
    private val items: MutableList<Int>
) :
    RecyclerView.Adapter<GridAdapter.ViewHolder>() {


    //    var items = 300
    var isLeft = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SearchIcBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        val holder = ViewHolder(binding)
        holder.setIsRecyclable(false)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setIsRecyclable(false)
        Log.d(TAG, "onBindViewHolder: position -- ${position}")
        try {
//
//            if (position == items - 1) {
//                addData(10)
//                return
//            }

            if (position == holder.adapterPosition && position == holder.layoutPosition) {

                val params = holder.binding.tv.layoutParams
                params.height = activity.resources.getDimensionPixelSize(R.dimen._120dp)

                if (position % 3 == 0) {

                    if (isLeft) {
                        params.height = activity.resources.getDimensionPixelSize(R.dimen._120dp)
                    } else {
                        params.height = activity.resources.getDimensionPixelSize(R.dimen._60dp)
                    }
                    isLeft = !isLeft

                    holder.binding.tv.layoutParams = params

                } else if (position % 3 == 1) {
                    if (isLeft) {
                        params.height = activity.resources.getDimensionPixelSize(R.dimen._120dp)
                    } else {
                        params.height = activity.resources.getDimensionPixelSize(R.dimen._60dp)
                    }
                    holder.binding.tv.layoutParams = params
                } else if (position % 3 == 2) {
                    params.height = activity.resources.getDimensionPixelSize(R.dimen._60dp)
                    holder.binding.tv.layoutParams = params
                }

                holder.binding.apply {
                    tv.text = (position + 1).toString()
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun getItemId(position: Int): Long {
//        Log.d(TAG, "getItemId: position -- ${position}")
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
//        Log.d(TAG, "getItemViewType: position -- ${position}")
        return position
    }

    companion object {
        private const val TAG = "SearchAdapter"
    }

    override fun getItemCount(): Int = items.size

//    fun addData(item: Int) {
//
//        val oldItem = items
//        items += item
//
//        recyclerView.post {
//            notifyItemRangeInserted(oldItem, item)
//        }
//
//    }

    inner class ViewHolder(val binding: SearchIcBinding) :
        RecyclerView.ViewHolder(binding.root)
}