package com.daydreamapplications.materialdesignadapter.simple

import androidx.annotation.LayoutRes
import com.daydreamapplications.adapter.data.MaterialDesignListItem
import com.daydreamapplications.materialdesignadapter.R

data class SimpleListItem(
    @get:LayoutRes
    override val layout: Int
) : MaterialDesignListItem {

    override val firstLine: Any = "First Line"
    override val secondLine: Any= "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    override val visual: Any = R.drawable.ic_launcher_background
}
