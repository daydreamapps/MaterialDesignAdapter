package com.daydreamapplications.adapter.layouts.line

import androidx.annotation.LayoutRes

interface VisualType {

    @get:LayoutRes
    val none: Int

    @get:LayoutRes
    val small: Int

    @get:LayoutRes
    val medium: Int

    @get:LayoutRes
    val large: Int
}