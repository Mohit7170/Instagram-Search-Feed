package com.app.instagramfeed.ui.activities

import android.app.Activity
import android.os.Bundle
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

        val manager = SpannedGridLayoutManager(
            object : SpannedGridLayoutManager.GridSpanLookup {
                override fun getSpanInfo(position: Int): SpannedGridLayoutManager.SpanInfo {
                    // Conditions for 2x2 items
                    return if (position % 6 == 0 || position % 6 == 4) {
                        SpannedGridLayoutManager.SpanInfo(2, 2)
                    } else {
                        SpannedGridLayoutManager.SpanInfo(1, 1)
                    }
                }
            },
            3,  // number of columns
            1.2f // how big is default item
        )


        val adapter = GridAdapter()

        binding.searchRv.apply {
            layoutManager = manager
            this.adapter = adapter
        }

    }
}