package com.daydreamapplications.materialdesignadapter.simple.visual

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daydreamapplications.adapter.MaterialDesignBindingAdapter
import com.daydreamapplications.adapter.data.MaterialDesignListItem
import com.daydreamapplications.adapter.layouts.Decorators
import com.daydreamapplications.adapter.layouts.visual.MediumVisualLayouts
import com.daydreamapplications.adapter.layouts.visual.SmallVisualLayouts
import com.daydreamapplications.materialdesignadapter.databinding.ActivityListBinding
import com.daydreamapplications.materialdesignadapter.simple.SimpleListItem

class MediumVisualItemsSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityListBinding.inflate(layoutInflater).apply {
            initRecyclerView(this)
            setContentView(root)
        }
    }

    private fun initRecyclerView(binding: ActivityListBinding) {
        binding.recyclerView.adapter = MaterialDesignBindingAdapter(viewModels)
        binding.recyclerView.addItemDecoration(Decorators.cardMarginMedium)
    }

    private val viewModels: List<MaterialDesignListItem>
        get() = listOf(
            MediumVisualLayouts.one,
            MediumVisualLayouts.two,
            MediumVisualLayouts.three
        ).map(::SimpleListItem)
}