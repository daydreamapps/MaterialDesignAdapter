package com.daydreamapplications.adapter

import android.app.Activity
import android.app.SharedElementCallback
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.daydreamapplications.bindingrecycler.BindingRecyclerView
import androidx.core.util.Pair as UtilPair


class MaterialDesignBindingAdapter(
    viewModels: Collection<HasLayoutBinding> = emptyList()
) : BindingRecyclerView.Adapter<HasLayoutBinding>(viewModels) {

//    var transitionDataOnClick: Boolean = false
//
//    init {
//        transitionDataOnClick = true
//    }

    override fun getItemLayoutRes(position: Int): Int = viewModels[position].layout

    override fun onClick(rootView: View, viewModel: HasLayoutBinding) {

//        if (transitionDataOnClick) {
//
//            //TODO: find a clean way to pass to ViewModel
//            (rootView.context as? Activity)?.let { activity ->
//                val makeSceneTransitionAnimation =
//                    ActivityOptionsCompat.makeSceneTransitionAnimation(
//                        activity,
//                        *MapSharedElements.transitionsElements(rootView)
//                    )
//            }
//        }
        if (viewModel is OnClickWithNavigationBundle) {
            val makeSceneTransitionAnimation = (rootView.context as? Activity)?.let { activity ->
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity,
                    *MapSharedElements.transitionsElements(rootView)
                )
            }

            viewModel.onClick(rootView, makeSceneTransitionAnimation)
        }
        super.onClick(rootView, viewModel)
    }


    override fun onBindViewHolder(holder: BindingRecyclerView.ViewHolder, position: Int) {

        super.onBindViewHolder(holder, position)
        MapSharedElements.assignTransitionNames(holder, position)
    }

    val sharedElementCallback: SharedElementCallback
        get() {
            return object : SharedElementCallback() {
                override fun onMapSharedElements(
                    names: MutableList<String>?,
                    sharedElements: MutableMap<String, View>?
                ) {
                    super.onMapSharedElements(names, sharedElements)

                }
            }
        }
    var clickTransitionViewHolder: HasLayoutBinding? = null
}

interface OnClickWithNavigationBundle {

    fun onClick(view: View, activityOptionsCompat: ActivityOptionsCompat?)
}

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

    fun transitionsElements(view: View?): Array<out UtilPair<View, String>> {
        return listOfNotNull<UtilPair<View, String>>(
            view.firstLine?.let { UtilPair.create(it as View, NAME_FIRST_LINE) },
            view.secondLine?.let { UtilPair.create(it as View, NAME_SECOND_LINE) },
            view.overLine?.let { UtilPair.create(it as View, NAME_OVER_LINE) },
            view.visualStart?.let { UtilPair.create(it as View, NAME_VISUAL) }
        ).toTypedArray()
    }

    fun onMapSharedElements(
        viewHolder: RecyclerView.ViewHolder,
        names: MutableList<String>,
        sharedElements: MutableMap<String, View>
    ) {

        val itemView = viewHolder.itemView

        if (names.contains(NAME_FIRST_LINE)) {
            itemView.firstLine?.let {
                sharedElements[NAME_FIRST_LINE] = it
            }
        }

        if (names.contains(NAME_SECOND_LINE)) {
            itemView.secondLine?.let {
                sharedElements[NAME_SECOND_LINE] = it
            }
        }

        if (names.contains(NAME_OVER_LINE)) {
            itemView.overLine?.let {
                sharedElements[NAME_OVER_LINE] = it
            }
        }

        if (names.contains(NAME_VISUAL)) {
            itemView.visualStart?.let {
                sharedElements[NAME_VISUAL] = it
            }
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
