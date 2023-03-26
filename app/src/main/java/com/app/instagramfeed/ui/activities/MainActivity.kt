package com.app.instagramfeed.ui.activities

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.app.instagramfeed.databinding.ActivityMainBinding
import com.app.instagramfeed.ui.adapter.GridAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var activity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        activity = this@MainActivity

        with(binding) {
            val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            val adapter = GridAdapter(activity, getItems())

            searchRv.apply {
                layoutManager = manager
                this.adapter = adapter
            }

            nsv.apply {
                viewTreeObserver.addOnScrollChangedListener {
                    val view = getChildAt(childCount - 1) as View
                    val diff = view.bottom - (height + scrollY)
                    val items = adapter.itemCount
                    if (diff == 0) adapter.addData(getItems(items+1, items + 30))
                }
            }
        }
    }

    private fun getItems(start: Int = 1, end: Int = 60): MutableList<Int> {
        val items = mutableListOf<Int>()
        for (i in start..end) {
            items.add(i)
        }
        return items
    }

    companion object {
        private const val TAG = "MainActivity"
    }

}