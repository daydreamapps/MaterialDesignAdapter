package com.daydreamapplications.materialdesignadapter.network

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.daydreamapplications.adapter.MaterialDesignBindingAdapter
import com.daydreamapplications.adapter.layouts.Decorators
import com.daydreamapplications.materialdesignadapter.databinding.ActivityMainBinding

class NetworkDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater)
            .apply {

                initRecycler(recyclerView)

                setContentView(root)
            }
    }

    private fun initRecycler(recyclerView: RecyclerView) {
        val dataProvider = NetworkDataProvider()
        val materialDesignBindingAdapter = MaterialDesignBindingAdapter()

        recyclerView.adapter = materialDesignBindingAdapter
        recyclerView.addItemDecoration(Decorators.cardMarginMedium)

        dataProvider.recipeListItems.observe(this@NetworkDemoActivity, Observer {
            materialDesignBindingAdapter.viewModels = it
        })
    }
}