package com.daydreamapplications.adapter.layouts

import androidx.annotation.LayoutRes

interface MaterialLayouts {

    @get:LayoutRes
    val noVisual: Int

    @get:LayoutRes
    val visualSmall: Int

    @get:LayoutRes
    val visualStandard: Int

    @get:LayoutRes
    val visualExtraLarge: Int
}