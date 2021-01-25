package com.daydreamapplications.adapter.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bindImage")
fun bindImage(imageView: ImageView, content: Any?) {

    when (content) {
        is Int -> {
            imageView.setImageResource(content)
        }
        is String -> {
            Glide.with(imageView)
                .load(content)
                .into(imageView)
        }
        else -> imageView.setImageDrawable(null)
    }
}