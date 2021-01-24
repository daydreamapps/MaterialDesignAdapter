package com.daydreamapplications.adapter.binding

import android.content.res.Resources.NotFoundException
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("bindText")
fun bindText(textView: TextView, content: Any?) {
    when(content) {
        null -> textView.text = ""
        is String -> textView.text = content
        is Int -> {
            try {
                textView.resources.getString(content)
            } catch (e: NotFoundException) {
                e.printStackTrace()
                textView.text = content.toString()
            }
        }
    }
}