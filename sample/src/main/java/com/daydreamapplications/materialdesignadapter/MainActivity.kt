package com.daydreamapplications.materialdesignadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daydreamapplications.adapter.DummyLayout
import com.daydreamapplications.adapter.MaterialDesignBindingAdapter
import com.daydreamapplications.materialdesignadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater)
            .apply {
                recyclerView.adapter = MaterialDesignBindingAdapter(listOf(DummyLayout, DummyLayout, DummyLayout))
                setContentView(root)
            }
    }
}