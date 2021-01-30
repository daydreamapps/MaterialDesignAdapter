package com.daydreamapplications.materialdesignadapter

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.daydreamapplications.adapter.OnClickWithNavigationOptions
import com.daydreamapplications.adapter.data.MaterialDesignListItem
import com.daydreamapplications.adapter.layouts.TwoLineLayouts

class RecipeListViewModel(
    private val recipeApi: RecipeApi
) : ViewModel() {

    private val recipes: LiveData<List<FoodItem>> = liveData {
        val response = recipeApi.recipes()
        emit(response.result)
    }

    val recipeListItems: LiveData<List<MaterialDesignListItem>> = Transformations.map(recipes) { recipes ->
        recipes.map(::RecipeListItem)
    }
}


data class RecipeListItem(
    private val foodItem: FoodItem
) : MaterialDesignListItem, OnClickWithNavigationOptions {

    override val firstLine: String get() = foodItem.name
    override val secondLine: String get() = foodItem.description
    override val visual: Any? get() = foodItem.imageUrl
    override val layout: Int get() = TwoLineLayouts.visualStandard

    override fun onClick(view: View, options: Bundle?) {
        DetailsActivity.startActivity(
            context = view.context,
            foodItem = foodItem,
            options = options
        )
    }
}