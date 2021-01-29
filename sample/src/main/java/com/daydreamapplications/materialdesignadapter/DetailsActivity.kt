package com.daydreamapplications.materialdesignadapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.daydreamapplications.adapter.TransitionNames
import com.daydreamapplications.materialdesignadapter.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityDetailsBinding.inflate(layoutInflater)
            .apply {
                title.text = intent.getStringExtra("title") ?: "Title missing"
                title.transitionName = TransitionNames.firstLine
                setContentView(root)
            }
    }

    companion object {

        fun startActivity(context: Context, title: String, options: Bundle? = null) {
            ActivityCompat.startActivity(context, startActivityIntent(context, title), options)
        }

        fun startActivityIntent(context: Context, title: String): Intent {
            return Intent(context, DetailsActivity::class.java)
                .putExtra("title", title)
        }
    }
}