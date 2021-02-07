package com.daydreamapplications.materialdesignadapter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daydreamapplications.materialdesignadapter.databinding.ActivityDemoSelectionBinding
import com.daydreamapplications.materialdesignadapter.network.NetworkDemoActivity
import kotlin.reflect.KClass

class DemoSelectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityDemoSelectionBinding.inflate(layoutInflater).apply {
            initButtons(this)
            setContentView(root)
        }

    }

    fun initButtons(binding: ActivityDemoSelectionBinding) {
        binding.buttonNetworkExample.setOnClickListener { startActivity(NetworkDemoActivity::class) }
    }

    fun startActivity(destination: KClass<*>) {
        startActivity(Intent(this, destination.java))
    }
}