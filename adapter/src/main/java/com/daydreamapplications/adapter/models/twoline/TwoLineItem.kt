package com.daydreamapplications.adapter.models.twoline

import com.daydreamapplications.adapter.HasLayoutBinding
import com.daydreamapplications.adapter.R
import com.daydreamapplications.adapter.models.FirstLine
import com.daydreamapplications.adapter.models.SecondLine

interface TwoLineItem : HasLayoutBinding, FirstLine, SecondLine {

    override val layout: Int
        get() = R.layout.item_two_line
}

