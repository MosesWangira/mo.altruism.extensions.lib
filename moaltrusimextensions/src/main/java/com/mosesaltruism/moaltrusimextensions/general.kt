package com.mosesaltruism.moaltrusimextensions

/**
 * @MosesAltruism
 * 5th July 2021
 */

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

fun <T:Any> ArrayList<T>.refreshList(items: List<T>): ArrayList<T>{
    this.clear()
    this.addAll(items)
    return this
}

fun <T:Any> ArrayList<T>.addNonExistingItem(item: List<T>): ArrayList<T>{
    item.forEach { if(!this.contains(it)) this.add(it) }
    return this
}

fun Activity.hasPermission(permission: String): Boolean {
    return ActivityCompat.checkSelfPermission(
        this,
        permission
    ) == PackageManager.PERMISSION_GRANTED
}