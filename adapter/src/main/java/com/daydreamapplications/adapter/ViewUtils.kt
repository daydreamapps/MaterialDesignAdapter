package com.daydreamapplications.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView

object ViewUtils {

    fun firstLine(rootView: View?): TextView? {
        return rootView?.findViewById(R.id.first_line)
    }

    fun secondLine(rootView: View?): TextView? {
        return rootView?.findViewById(R.id.second_line)
    }

    fun overLine(rootView: View?): TextView? {
        return rootView?.findViewById(R.id.overline)
    }

    fun visualStart(rootView: View?): ImageView? {
        return rootView?.findViewById(R.id.visual_start)
    }
}