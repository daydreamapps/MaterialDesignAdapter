package com.daydreamapplications.materialdesignadapter.network

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.bumptech.glide.Glide
import com.daydreamapplications.adapter.TransitionNames
import com.daydreamapplications.materialdesignadapter.databinding.ActivityDetailsBinding

class NetworkDemoDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val foodItem = intent.getParcelableExtra<NetworkDataProvider.FoodItem>("foodItem") ?: throw IllegalStateException("FoodItem data missing")

        ActivityDetailsBinding.inflate(layoutInflater)
            .apply {

                banner.transitionName = TransitionNames.visual
                Glide.with(this@NetworkDemoDetailsActivity)
                    .load(foodItem.imageUrl)
                    .into(banner)


                title.text = foodItem.name
                title.transitionName = TransitionNames.firstLine

                setContentView(root)
            }
    }

    companion object {

        fun startActivity(context: Context, foodItem: NetworkDataProvider.FoodItem, options: Bundle? = null) {
            ActivityCompat.startActivity(context, startActivityIntent(context, foodItem), options)
        }

        fun startActivityIntent(context: Context, foodItem: NetworkDataProvider.FoodItem): Intent {
            return Intent(context, NetworkDemoDetailsActivity::class.java)
                .putExtra("foodItem", foodItem)
        }
    }
}