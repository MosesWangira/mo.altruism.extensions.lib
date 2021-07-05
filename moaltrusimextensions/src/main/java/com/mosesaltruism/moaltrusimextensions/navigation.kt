package com.mosesaltruism.moaltrusimextensions

/**
 * @MosesAltruism
 * 5th July 2021
 */

import android.view.View
import androidx.navigation.findNavController

fun View.navigator(resId: Int) {
    findNavController().navigate(resId)
}