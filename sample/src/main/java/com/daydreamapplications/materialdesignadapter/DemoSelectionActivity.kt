package com.daydreamapplications.materialdesignadapter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daydreamapplications.materialdesignadapter.databinding.ActivityDemoSelectionBinding
import com.daydreamapplications.materialdesignadapter.network.NetworkDemoActivity
import com.daydreamapplications.materialdesignadapter.simple.visual.MediumVisualItemsSampleActivity
import com.daydreamapplications.materialdesignadapter.simple.visual.SmallVisualItemsSampleActivity
import com.daydreamapplications.materialdesignadapter.simple.visual.TextOnlyListItemsActivity
import kotlin.reflect.KClass

class DemoSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityDemoSelectionBinding.inflate(layoutInflater).apply {
            initButtons(this)
            setContentView(root)
        }

    }

    private fun initButtons(binding: ActivityDemoSelectionBinding) {
        //  Simple Examples
        binding.buttonTextOnly.setOnClickListener { startActivity(TextOnlyListItemsActivity::class) }
        binding.buttonSmallVisual.setOnClickListener { startActivity(SmallVisualItemsSampleActivity::class) }
        binding.buttonMediumVisual.setOnClickListener { startActivity(MediumVisualItemsSampleActivity::class) }
        binding.buttonLargeVisual.setOnClickListener { }

        // Further Examples
        binding.buttonNetworkExample.setOnClickListener { startActivity(NetworkDemoActivity::class) }
    }
}

fun Activity.startActivity(destination: KClass<*>) {
    startActivity(Intent(this, destination.java))
}
