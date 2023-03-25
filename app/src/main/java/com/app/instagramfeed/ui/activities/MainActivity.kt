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
            val adapter = GridAdapter(activity, binding.searchRv)

            searchRv.apply {
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                this.adapter = adapter
            }

            nsv.apply {
                viewTreeObserver.addOnScrollChangedListener {
                    val view = getChildAt(childCount - 1) as View
                    val diff = view.bottom - (height + scrollY)
                    if (diff == 0) adapter.addData(20)
                }
            }
        }

    }

    companion object {
        private const val TAG = "MainActivity"
    }

}