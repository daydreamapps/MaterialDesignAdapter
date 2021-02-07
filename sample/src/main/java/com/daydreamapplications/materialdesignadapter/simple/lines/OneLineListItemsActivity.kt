package com.daydreamapplications.materialdesignadapter.simple.lines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daydreamapplications.adapter.MaterialDesignBindingAdapter
import com.daydreamapplications.adapter.data.MaterialDesignListItem
import com.daydreamapplications.adapter.layouts.Decorators
import com.daydreamapplications.adapter.layouts.line.OneLineLayouts
import com.daydreamapplications.materialdesignadapter.databinding.ActivityListBinding
import com.daydreamapplications.materialdesignadapter.simple.SimpleListItem

class OneLineListItemsActivity : AppCompatActivity() {

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
            OneLineLayouts.none,
            OneLineLayouts.small,
            OneLineLayouts.medium,
            OneLineLayouts.large
        ).map(::SimpleListItem)
}