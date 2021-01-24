package com.daydreamapplications.adapter.models.twoline

import androidx.annotation.StringRes

class SimpleTwoLineItem : TwoLineItem {

    override val firstLine: Any
    override val secondLine: Any

    constructor(
        @StringRes firstLine: Int,
        @StringRes secondLine: Int
    ) {
        this.firstLine = firstLine
        this.secondLine = secondLine
    }

    constructor(
        firstLine: String,
        secondLine: String
    ) {
        this.firstLine = firstLine
        this.secondLine = secondLine
    }
}