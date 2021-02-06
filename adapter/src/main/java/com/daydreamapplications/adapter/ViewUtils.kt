package com.daydreamapplications.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView

internal object ViewUtils {

    internal fun firstLine(rootView: View?): TextView? {
        return rootView?.findViewById(R.id.first_line)
    }

    internal fun secondLine(rootView: View?): TextView? {
        return rootView?.findViewById(R.id.second_line)
    }

    internal fun visualStart(rootView: View?): ImageView? {
        return rootView?.findViewById(R.id.visual_start)
    }
}