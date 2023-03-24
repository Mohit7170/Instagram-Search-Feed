package com.app.instagramfeed.ui.activities

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.app.instagramfeed.custom.SpannedGridLayoutManager
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

        var i = 10
        var j = 1

        val manager = SpannedGridLayoutManager(
            object : SpannedGridLayoutManager.GridSpanLookup {
                override fun getSpanInfo(position: Int): SpannedGridLayoutManager.SpanInfo {
                    // Conditions for 2x2 items
                    Log.d(TAG, "getSpanInfo: position -- $position")
                    return if (position % 6 == 0 || position % 6 == 4) {
                        SpannedGridLayoutManager.SpanInfo(2, 2)
                    } else {
                        SpannedGridLayoutManager.SpanInfo(1, 1)
                    }
                }
            },
            3,  // number of columns
            0.95f // how big is default item
        )

        val adapter = GridAdapter(binding.searchRv)

        binding.searchRv.apply {
            layoutManager = manager
            this.adapter = adapter

//            addOnScrollListener(object : RecyclerView.OnScrollListener() {
//                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                    super.onScrolled(recyclerView, dx, dy)
//
//                    Log.d(TAG, "onScrolled: recyclerView.canScrollVertically(1) -- ${recyclerView.canScrollVertically(1)}   dy -- ${dy}")
////                    if (!recyclerView.canScrollVertically(-1) && dy < 0) {
//                    if (!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
//
//                        adapter.addData(10)
//                        Log.d(TAG, "onScrolled: BOTTOM")
////                        recyclerView.invalidate()
//                    }
//                }
//            })
        }

    }

    companion object {
        private const val TAG = "MainActivity"
    }

}