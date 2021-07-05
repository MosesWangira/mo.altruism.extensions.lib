package com.mosesaltruism.moaltrusimextensions

/**
 * @MosesAltruism
 * 5th July 2021
 */

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController

/**
 * Single view animation
 * */
fun viewAnimation(context: Context, resId: Int): Animation {
    return AnimationUtils.loadAnimation(context, resId)
}

/**
 * Whole layout animation e.g recyclerview or linearlayout
 * */
fun layoutAnimation(context: Context, resId: Int): LayoutAnimationController {
    return AnimationUtils.loadLayoutAnimation(context, resId)
}