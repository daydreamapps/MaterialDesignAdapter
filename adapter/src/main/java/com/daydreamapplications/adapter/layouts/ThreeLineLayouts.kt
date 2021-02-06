package com.daydreamapplications.adapter.layouts

import androidx.annotation.LayoutRes
import com.daydreamapplications.adapter.R

object ThreeLineLayouts: VisualType {

    @get:LayoutRes
    val overline: Int = R.layout.item_three_line_overline

    @get:LayoutRes
    override val none: Int = R.layout.item_three_line_no_visual

    @get:LayoutRes
    override val small: Int = R.layout.item_three_line_small_visual

    @get:LayoutRes
    override val medium: Int = R.layout.item_three_line_standard_visual

    @get:LayoutRes
    override val large: Int = R.layout.item_three_line_large_visual
}