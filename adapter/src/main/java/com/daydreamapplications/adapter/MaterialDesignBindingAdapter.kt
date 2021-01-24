package com.daydreamapplications.adapter

import com.daydreamapplications.bindingrecycler.BindingRecyclerView

class MaterialDesignBindingAdapter(
    viewModels: Collection<HasLayoutBinding> = emptyList()
) : BindingRecyclerView.Adapter<HasLayoutBinding>(viewModels) {

    override fun getItemLayoutRes(position: Int): Int = viewModels[position].layout
}