package com.daydreamapplications.adapter.models.singleline

import androidx.annotation.StringRes

class SimpleSingleLineItem : SingleLineItem {

    override val firstLine: Any

    constructor(@StringRes firstLine: Int) {
        this.firstLine = firstLine
    }

    constructor(firstLine: String) {
        this.firstLine = firstLine

    }
}