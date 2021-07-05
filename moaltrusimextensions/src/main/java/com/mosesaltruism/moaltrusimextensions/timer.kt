package com.mosesaltruism.moaltrusimextensions

/**
 * @MosesAltruism
 * 5th July 2021
 */

import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.widget.TextView

fun reverseTimer(Seconds: Int, displayText: TextView, endText: String) {
    object : CountDownTimer((Seconds * 1000 + 1000).toLong(), 1000) {
        @SuppressLint("SetTextI18n")
        override fun onTick(millisUntilFinished: Long) {
            var seconds = (millisUntilFinished / 1000).toInt()
            val hours = seconds / (60 * 60)
            val tempMint = seconds - hours * 60 * 60
            val minutes = tempMint / 60
            seconds = tempMint - minutes * 60
            displayText.text = "${String.format("%02d", hours)} : ${
                String.format(
                    "%02d",
                    minutes
                )
            } : ${String.format("%02d", seconds)}"
        }

        override fun onFinish() {
            displayText.text = endText
        }
    }.start()
}