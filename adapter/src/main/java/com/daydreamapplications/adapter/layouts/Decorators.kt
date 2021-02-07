package com.daydreamapplications.adapter.layouts

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import com.daydreamapplications.adapter.R

object Decorators {

    val cardMarginSmall: RecyclerView.ItemDecoration
        get() = MarginItemDecoration(R.dimen.card_decoration_margin_small)

    val cardMarginMedium: RecyclerView.ItemDecoration
        get() = MarginItemDecoration(R.dimen.card_decoration_margin_medium)

    class MarginItemDecoration(@DimenRes private val margin: Int) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            super.getItemOffsets(outRect, view, parent, state)
            val marginInPx = parent.resources.getDimension(margin).toInt()

            // ensure consistent margin on both axis
            val marginBottom = if (parent.getChildAdapterPosition(view) == 0)  marginInPx else 0
            outRect.set(marginInPx, marginBottom, marginInPx, marginInPx)
        }
    }
}