package com.daydreamapplications.adapter

import android.view.View
import androidx.core.app.ActivityOptionsCompat

interface OnClickWithNavigationBundle {

    fun onClick(view: View, activityOptionsCompat: ActivityOptionsCompat?)
}