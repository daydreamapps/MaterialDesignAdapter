package com.daydreamapplications.adapter.data

import com.daydreamapplications.adapter.HasLayoutBinding

interface MaterialDesignListItem : HasLayoutBinding {

    /**
     * Accepted types: @StringRes Int, String, null
     * Other types ignored
     */
    val firstLine: Any?


    /**
     * Accepted types: @StringRes Int, String, null
     * Other types ignored
     */
    val secondLine: Any? get() = null

    /**
     * Accepted types: @StringRes Int, String, null
     * Other types ignored
     */
    val overline: Any? get() = null

    /**
     * Accepted types: @DrawableRes Int, String (url), null
     * Other types ignored
     */
    val visual: Any? get() = null
}