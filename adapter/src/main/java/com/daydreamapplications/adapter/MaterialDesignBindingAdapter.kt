package com.daydreamapplications.adapter

import android.view.View
import com.daydreamapplications.bindingrecycler.BindingRecyclerView

class MaterialDesignBindingAdapter(
    viewModels: Collection<HasLayoutBinding> = emptyList()
) : BindingRecyclerView.Adapter<HasLayoutBinding>(viewModels) {

    override fun getItemLayoutRes(position: Int): Int = viewModels[position].layout

    override fun onClick(rootView: View, viewModel: HasLayoutBinding) {
        if (viewModel is OnClickWithNavigationBundle) {
            val activityOptionsCompat = TransitionOptions.constructOptions(rootView)
            viewModel.onClick(rootView, activityOptionsCompat)
        }
        super.onClick(rootView, viewModel)
    }

    override fun onBindViewHolder(holder: BindingRecyclerView.ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        TransitionNames.assignToViewInPosition(holder.itemView, position)
    }
}
