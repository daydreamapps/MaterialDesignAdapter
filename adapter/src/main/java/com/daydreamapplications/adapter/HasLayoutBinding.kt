package com.daydreamapplications.adapter

import androidx.annotation.LayoutRes

interface HasLayoutBinding {

    @get:LayoutRes
    val layout: Int
}