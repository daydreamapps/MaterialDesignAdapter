package com.daydreamapplications.materialdesignadapter.network

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.daydreamapplications.adapter.OnClickWithNavigationOptions
import com.daydreamapplications.adapter.data.MaterialDesignListItem
import com.daydreamapplications.adapter.layouts.line.TwoLineLayouts
import kotlinx.android.parcel.Parcelize
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class NetworkDataProvider {

    private val recipeApi: RecipeApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/daydreamapps/MaterialDesignAdapter/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RecipeApi::class.java)
    }

    val recipeListItems: LiveData<List<RecipeListItem>> = liveData {
        val response = recipeApi.recipes()
        val items = response.result.map(::RecipeListItem)
        emit(items)
    }

    data class RecipeListItem(
        private val foodItem: FoodItem
    ) : MaterialDesignListItem, OnClickWithNavigationOptions {

        override val firstLine: String get() = foodItem.name
        override val secondLine: String get() = foodItem.description
        override val visual: Any? get() = foodItem.imageUrl
        override val layout: Int get() = TwoLineLayouts.medium

        override fun onClick(view: View, options: Bundle?) {
            NetworkDemoDetailsActivity.startActivity(
                context = view.context,
                foodItem = foodItem,
                options = options
            )
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

    interface RecipeApi {

        @GET("master/sample/assets/recipe_response.json")
        suspend fun recipes(): FoodItemsResponse
    }
}