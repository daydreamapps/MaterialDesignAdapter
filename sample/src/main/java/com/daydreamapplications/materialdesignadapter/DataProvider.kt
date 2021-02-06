package com.daydreamapplications.materialdesignadapter

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object DataProvider {

    private val retrofit: Retrofit by lazy {

        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/daydreamapps/MaterialDesignAdapter/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val recipeApi: RecipeApi by lazy {
        retrofit.create(RecipeApi::class.java)
    }
}

interface RecipeApi {

    @GET("master/sample/assets/recipe_response.json")
    suspend fun recipes(): FoodItemsResponse
}