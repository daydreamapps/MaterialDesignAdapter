package com.daydreamapplications.adapter

import android.app.Activity
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair

internal object TransitionOptions {

    internal fun constructOptions(rootView: View?): ActivityOptionsCompat? {
        val transitionViews: Array<Pair<View, String>> = listOfNotNull(
            transitionPair(ViewUtils.firstLine(rootView), TransitionNames.firstLine),
            transitionPair(ViewUtils.secondLine(rootView), TransitionNames.secondLine),
            transitionPair(ViewUtils.overLine(rootView), TransitionNames.overLine),
            transitionPair(ViewUtils.visualStart(rootView), TransitionNames.visual)
        ).toTypedArray()

        return constructOptions(rootView, transitionViews)
    }

    internal fun constructOptions(
        view: View?,
        transitionViews: Array<Pair<View, String>>
    ): ActivityOptionsCompat? {
        return (view?.context as? Activity)?.let { activity ->
            ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity,
                *transitionViews
            )
        }
    }

    internal fun transitionPair(view: View?, name: String): Pair<View, String>? {
        return if (view != null) {
            Pair.create(view, name)
        } else null
    }
}
