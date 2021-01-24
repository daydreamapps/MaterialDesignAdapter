package com.daydreamapplications.adapter.models.singleline

import com.daydreamapplications.adapter.HasLayoutBinding
import com.daydreamapplications.adapter.R
import com.daydreamapplications.adapter.models.FirstLine

interface SingleLineItem : HasLayoutBinding,
    FirstLine {

    override val layout: Int
        get() = R.layout.item_single_line
}

