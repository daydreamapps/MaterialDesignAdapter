package com.daydreamapplications.adapter

import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.daydreamapplications.bindingrecycler.BindingRecyclerView

object MapSharedElements {

    const val NAME_FIRST_LINE = "transition_firstLine"
    const val NAME_SECOND_LINE = "transition_secondLine"
    const val NAME_OVER_LINE = "transition_overline"
    const val NAME_VISUAL = "transition_visual"

    fun assignTransitionNames(holder: BindingRecyclerView.ViewHolder, position: Int) {
        holder.itemView.firstLine?.transitionName = "$NAME_FIRST_LINE-$position"
        holder.itemView.secondLine?.transitionName = "$NAME_SECOND_LINE-$position"
        holder.itemView.overLine?.transitionName = "$NAME_OVER_LINE-$position"
        holder.itemView.visualStart?.transitionName = "$NAME_VISUAL-$position"
    }

    fun constructActivityOptions(view: View?): ActivityOptionsCompat? {
        val transitionViews = listOfNotNull<Pair<View, String>>(
            view.firstLine?.let {
                Pair.create(
                    it as View,
                    NAME_FIRST_LINE
                )
            },
            view.secondLine?.let {
                Pair.create(
                    it as View,
                    NAME_SECOND_LINE
                )
            },
            view.overLine?.let {
                Pair.create(
                    it as View,
                    NAME_OVER_LINE
                )
            },
            view.visualStart?.let {
                Pair.create(
                    it as View,
                    NAME_VISUAL
                )
            }
        ).toTypedArray()

        return constructActivityOptions(view, transitionViews)
    }

    fun constructActivityOptions(
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

    val View?.firstLine: TextView?
        get() = this?.findViewById(R.id.first_line)

    val View?.secondLine: TextView?
        get() = this?.findViewById(R.id.second_line)

    val View?.overLine: TextView?
        get() = this?.findViewById(R.id.overline)

    val View?.visualStart: ImageView?
        get() = this?.findViewById(R.id.visual_start)
}