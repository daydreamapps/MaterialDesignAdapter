package com.daydreamapplications.materialdesignadapter

import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.daydreamapplications.adapter.MaterialDesignBindingAdapter
import com.daydreamapplications.adapter.layouts.Decorators
import com.daydreamapplications.materialdesignadapter.databinding.ActivityMainBinding
import kotlinx.android.parcel.Parcelize


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater)
            .apply {

                lifecycleOwner = this@MainActivity
                recyclerView.adapter = MaterialDesignBindingAdapter()
                recyclerView.addItemDecoration(Decorators.cardMargin)
                viewModel = RecipeListViewModel(DataProvider.recipeApi)

                setContentView(root)
            }
    }
}

data class FoodItemsResponse(
    val result: List<FoodItem>
)

@Parcelize
data class FoodItem(
    val name: String,
    val description: String,
    val imageUrl: String
) : Parcelable