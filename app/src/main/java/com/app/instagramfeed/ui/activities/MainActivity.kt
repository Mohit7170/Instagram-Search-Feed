package com.app.instagramfeed.ui.activities

import android.app.Activity
import android.os.Bundle
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

        val adapter = GridAdapter(activity, binding.searchRv, getItems())
        adapter.setHasStableIds(true)

        val manager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        val manager = LinearLayoutManager


        binding.searchRv.apply {
            layoutManager = manager
            this.adapter = adapter


        }

    }

    private fun getItems(): MutableList<Int> {
        val item: MutableList<Int> = mutableListOf()
        for (i in 0..300) {
            item.add(i)
        }
        return item
    }


    companion object {
        private const val TAG = "MainActivity"
    }

}