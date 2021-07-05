@file:Suppress("DEPRECATION")

package com.mosesaltruism.moaltrusimextensions

/**
 * @MosesAltruism
 * 5th July 2021
 */

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

/**
 * SnackBar with no action
 * */
fun View.snackBar(text: String) {
    Snackbar.make(this, text, Snackbar.LENGTH_LONG).show()
}

/**
 * SnackBar with action
 * */
fun View.snackBarAction(msg: String, actionText: String) {
    Snackbar.make(this, msg, Snackbar.LENGTH_LONG).also { snackBar ->
        snackBar.setAction(actionText) {
            snackBar.dismiss()
        }
    }.show()
}

/**
 * SnackBar with your intended color as background
 * */
fun View.snackBarAction(
    msg: String,
    actionText: String,
    activity: Activity,
    textColor: Int,
    snackBarBackgroundColor: Int
) {
    Snackbar.make(this, msg, Snackbar.LENGTH_LONG).also { snackBar ->
        snackBar.setBackgroundTint(ContextCompat.getColor(activity, snackBarBackgroundColor))
        snackBar.setTextColor(ContextCompat.getColor(activity, textColor))
        snackBar.setAction(actionText) {
            snackBar.dismiss()
        }
    }.show()
}


fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Activity.findAndSetTextInTextView(@IdRes id: Int, text: String) {
    findViewById<TextView>(id).text = text
}

fun isEditEmpty(string: String): Boolean {
    return string == ""
}

fun Activity.hideSoftKeyBoard() {
    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
}

fun Activity.makeFullScreen() {
    window.setFlags(
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
    )
}

fun Activity.disableFullScreen() {
    window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
}

fun Activity.close(v: View) {
    v.setOnClickListener {
        onBackPressed()
    }
}


fun shortVibrate(context: Context) {
    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (vibrator.hasVibrator()) { // Vibrator availability checking
        // Vibrate method for below API Level 26
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // New vibrate method for API Level 26 or higher
            vibrator.vibrate(
                VibrationEffect.createOneShot(
                    500,
                    VibrationEffect.DEFAULT_AMPLITUDE
                )
            )
        } else vibrator.vibrate(500)
    }
}


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun Activity.changeStatusBarColor(color: String) {
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.statusBarColor = Color.parseColor(color)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
}