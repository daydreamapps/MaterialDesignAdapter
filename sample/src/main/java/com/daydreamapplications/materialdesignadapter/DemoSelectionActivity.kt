package com.daydreamapplications.materialdesignadapter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daydreamapplications.materialdesignadapter.databinding.ActivityDemoSelectionBinding
import com.daydreamapplications.materialdesignadapter.network.NetworkDemoActivity
import com.daydreamapplications.materialdesignadapter.simple.lines.OneLineListItemsActivity
import com.daydreamapplications.materialdesignadapter.simple.lines.ThreeLineListItemsActivity
import com.daydreamapplications.materialdesignadapter.simple.lines.TwoLineListItemsActivity
import com.daydreamapplications.materialdesignadapter.simple.visual.LargeVisualItemsSampleActivity
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

        // By Line Count
        binding.buttonOneLine.setOnClickListener { startActivity(OneLineListItemsActivity::class) }
        binding.buttonTwoLine.setOnClickListener { startActivity(TwoLineListItemsActivity::class) }
        binding.buttonThreeLine.setOnClickListener { startActivity(ThreeLineListItemsActivity::class) }

        // By Visual Size
        binding.buttonTextOnly.setOnClickListener { startActivity(TextOnlyListItemsActivity::class) }
        binding.buttonSmallVisual.setOnClickListener { startActivity(SmallVisualItemsSampleActivity::class) }
        binding.buttonMediumVisual.setOnClickListener { startActivity(MediumVisualItemsSampleActivity::class) }
        binding.buttonLargeVisual.setOnClickListener { startActivity(LargeVisualItemsSampleActivity::class) }


        // Further Examples
        binding.buttonNetworkExample.setOnClickListener { startActivity(NetworkDemoActivity::class) }
    }
}

fun Activity.startActivity(destination: KClass<*>) {
    startActivity(Intent(this, destination.java))
}
