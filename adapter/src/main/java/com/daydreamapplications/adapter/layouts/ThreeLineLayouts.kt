package com.daydreamapplications.adapter.layouts

import androidx.annotation.LayoutRes
import com.daydreamapplications.adapter.R

object ThreeLineLayouts: MaterialLayouts {

    @get:LayoutRes
    val overline: Int = R.layout.item_three_line_overline

    @get:LayoutRes
    override val noVisual: Int = R.layout.item_three_line_no_visual

    @get:LayoutRes
    override val visualSmall: Int = R.layout.item_three_line_small_visual

    @get:LayoutRes
    override val visualStandard: Int = R.layout.item_three_line_standard_visual

    @get:LayoutRes
    override val visualExtraLarge: Int = R.layout.item_three_line_extra_large_visual
}