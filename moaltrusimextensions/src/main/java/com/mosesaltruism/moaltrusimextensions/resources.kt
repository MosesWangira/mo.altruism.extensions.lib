package com.mosesaltruism.moaltrusimextensions

/**
 * @MosesAltruism
 * 5th July 2021
 */

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

fun Context.getMyColor(@ColorRes color: Int): Int {
    return ContextCompat.getColor(this, color)
}

fun Context.getMyDrawable(@DrawableRes drawable: Int): Drawable {
    return ContextCompat.getDrawable(this, drawable)!!
}