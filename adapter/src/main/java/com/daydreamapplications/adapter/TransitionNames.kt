package com.daydreamapplications.adapter

import android.view.View

object TransitionNames {

    const val firstLine = "transition_firstLine"
    const val secondLine = "transition_secondLine"
    const val visual = "transition_visual"

    fun assignToViewInPosition(rootView: View?, position: Int) {
        ViewUtils.firstLine(rootView)?.transitionName = "$firstLine-$position"
        ViewUtils.secondLine(rootView)?.transitionName = "$secondLine-$position"
        ViewUtils.visualStart(rootView)?.transitionName = "$visual-$position"
    }
}