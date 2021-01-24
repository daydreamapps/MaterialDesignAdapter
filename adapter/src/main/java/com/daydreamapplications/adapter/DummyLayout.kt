package com.daydreamapplications.adapter

import androidx.annotation.LayoutRes

object DummyLayout : HasLayoutBinding {

    @get:LayoutRes
    override val layout: Int
        get() = R.layout.placeholder
}