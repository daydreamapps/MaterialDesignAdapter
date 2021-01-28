package com.daydreamapplications.materialdesignadapter

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.daydreamapplications.adapter.MaterialDesignBindingAdapter
import com.daydreamapplications.adapter.OnClickWithNavigationBundle
import com.daydreamapplications.adapter.data.MaterialDesignListItem
import com.daydreamapplications.adapter.layouts.OneLineLayouts
import com.daydreamapplications.adapter.layouts.ThreeLineLayouts
import com.daydreamapplications.adapter.layouts.TwoLineLayouts
import com.daydreamapplications.materialdesignadapter.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.io.BufferedReader


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater)
            .apply {

                val materialDesignBindingAdapter = MaterialDesignBindingAdapter(viewModels = listItems)
                recyclerView.adapter = materialDesignBindingAdapter

                setContentView(root)
            }
    }

    val listItems: List<FoodListItem>
        get() = loadData().result.map(FoodListItem.Companion::twoLine)

    fun loadData(): FoodItemsResponse {
        val json = resources.openRawResource(R.raw.food_response)
            .bufferedReader()
            .use(BufferedReader::readText)

        return Gson().fromJson(json, FoodItemsResponse::class.java)
    }
}

data class FoodItemsResponse(
    val result: List<FoodItem>
)

data class FoodItem(
    val name: String,
    val description: String,
    val imageUrl: String
)

data class FoodListItem(
    private val foodItem: FoodItem,
    @LayoutRes override val layout: Int
) : MaterialDesignListItem, OnClickWithNavigationBundle {

    override val firstLine: String get() = foodItem.name
    override val secondLine: String get() = foodItem.description
    override val visual: Any? get() = foodItem.imageUrl

    override fun onClick(view: View, activityOptionsCompat: ActivityOptionsCompat?) {
        DetailsActivity.startActivity(
            context = view.context,
            title = firstLine,
            options = activityOptionsCompat?.toBundle()
        )
    }

    companion object {

        fun oneLine(foodItem: FoodItem): FoodListItem {
            return FoodListItem(foodItem, OneLineLayouts.visualSmall)
        }

        fun twoLine(foodItem: FoodItem): FoodListItem {
            return FoodListItem(foodItem, TwoLineLayouts.visualStandard)
        }

        fun threeLine(foodItem: FoodItem): FoodListItem {
            return FoodListItem(foodItem, ThreeLineLayouts.visualExtraLarge)
        }
    }
}