package com.daydreamapplications.adapter.layouts

import androidx.annotation.LayoutRes
import com.daydreamapplications.adapter.R

object OneLineLayouts: MaterialLayouts {

    @get:LayoutRes
    override val noVisual: Int = R.layout.item_one_line_no_visual

    @get:LayoutRes
    override val visualSmall: Int = R.layout.item_one_line_visual_small

    @get:LayoutRes
    override val visualStandard: Int = R.layout.item_one_line_visual_standard

    @get:LayoutRes
    val visualLarge: Int = R.layout.item_one_line_visual_large

    @get:LayoutRes
    override val visualExtraLarge: Int = R.layout.item_one_line_visual_extra_large
}