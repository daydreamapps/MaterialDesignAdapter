package com.daydreamapplications.adapter.layouts

import androidx.annotation.LayoutRes
import com.daydreamapplications.adapter.R

object TwoLineLayouts {

    @get:LayoutRes
    val noVisual: Int = R.layout.item_two_line_no_visual

    @get:LayoutRes
    val visualSmall: Int = R.layout.item_two_line_small_visual

    @get:LayoutRes
    val visualStandard: Int = R.layout.item_two_line_standard_visual

    @get:LayoutRes
    val visualExtraLarge: Int = R.layout.item_two_line_extra_large_visual
}