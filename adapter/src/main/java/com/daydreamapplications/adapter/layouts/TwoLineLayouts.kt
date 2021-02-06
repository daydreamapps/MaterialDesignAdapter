package com.daydreamapplications.adapter.layouts

import androidx.annotation.LayoutRes
import com.daydreamapplications.adapter.R

object TwoLineLayouts: VisualType {

    @get:LayoutRes
    override val none: Int = R.layout.item_two_line_no_visual

    @get:LayoutRes
    override val small: Int = R.layout.item_two_line_small_visual

    @get:LayoutRes
    override val medium: Int = R.layout.item_two_line_standard_visual

    @get:LayoutRes
    override val large: Int = R.layout.item_two_line_large_visual
}