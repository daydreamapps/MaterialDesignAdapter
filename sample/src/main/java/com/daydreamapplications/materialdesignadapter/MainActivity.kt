package com.daydreamapplications.materialdesignadapter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.daydreamapplications.adapter.MaterialDesignBindingAdapter
import com.daydreamapplications.adapter.OnClickWithNavigationBundle
import com.daydreamapplications.adapter.data.MaterialDesignListItem
import com.daydreamapplications.adapter.layouts.OneLineLayouts
import com.daydreamapplications.adapter.layouts.TwoLineLayouts
import com.daydreamapplications.materialdesignadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater)
            .apply {
                recyclerView.adapter = MaterialDesignBindingAdapter(
                    listOf(
                        singleLine,
                        singleLine,
                        twoLine,
                        SimpleClicked(
                            firstLine = "It's me Dave",
                            secondLine = "Let me tell you a little about myself, if only to take up space in this item"
                        )
                    )
                )

                setContentView(root)
            }
    }

    val singleLine: MaterialDesignListItem
        get() {
            return object : MaterialDesignListItem {
                override val layout: Int = OneLineLayouts.visualSmall
                override val firstLine: Any? = "Hello World"
                override val visual: Any? = R.drawable.ic_launcher_foreground
            }
        }

    val twoLine: MaterialDesignListItem
        get() {
            return object : MaterialDesignListItem {
                override val layout: Int = TwoLineLayouts.visualExtraLarge
                override val firstLine: Any? = "It's me Dave"
                override val secondLine: Any? =
                    "Let me tell you a little about myself, if only to take up space in this item"
                override val visual: Any? = R.drawable.ic_launcher_background
            }
        }
}

data class SimpleClicked(
    override val firstLine: String,
    override val secondLine: String
) : MaterialDesignListItem, OnClickWithNavigationBundle {

    override val layout: Int = TwoLineLayouts.visualExtraLarge
    override val visual: Any? = R.drawable.ic_launcher_background

    override fun onClick(view: View, activityOptionsCompat: ActivityOptionsCompat?) {
        DetailsActivity.startActivity(
            context = view.context,
            title = firstLine,
            options = activityOptionsCompat?.toBundle()
        )
    }
}