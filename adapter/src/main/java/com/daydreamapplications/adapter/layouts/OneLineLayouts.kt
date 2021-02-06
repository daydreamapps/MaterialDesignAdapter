package com.daydreamapplications.adapter.layouts

import androidx.annotation.LayoutRes
import com.daydreamapplications.adapter.R

object OneLineLayouts: VisualType {

    @get:LayoutRes
    override val none: Int = R.layout.item_one_line_no_visual

    @get:LayoutRes
    override val small: Int = R.layout.item_one_line_visual_small

    @get:LayoutRes
    override val medium: Int = R.layout.item_one_line_visual_standard

    @get:LayoutRes
    override val large: Int = R.layout.item_one_line_visual_large
}