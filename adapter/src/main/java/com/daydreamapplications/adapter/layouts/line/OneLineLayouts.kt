package com.daydreamapplications.adapter.layouts.line

import androidx.annotation.LayoutRes
import com.daydreamapplications.adapter.R

object OneLineLayouts : VisualType {

    @get:LayoutRes
    override val none: Int = R.layout.card_text_only_one_line

    @get:LayoutRes
    override val small: Int = R.layout.card_small_one_line

    @get:LayoutRes
    override val medium: Int = R.layout.card_medium_one_line

    @get:LayoutRes
    override val large: Int = R.layout.card_large_one_line
}