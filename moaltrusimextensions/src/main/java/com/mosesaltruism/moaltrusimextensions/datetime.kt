package com.mosesaltruism.moaltrusimextensions

/**
 * @MosesAltruism
 * 5th July 2021
 */

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/***
 * @Include
 * all date patterns here
 * yyy-MM-dd'T'HH:mm:ss.SSS'Z'
 * dd MMM yyyy, HH:mm aa
 * E, dd MMM ''yy
 * dd MMM,yyyy HH:mm
 * dd-MMM-yyyy
 * HH:mm aa
 * */


fun getCurrentDateTime(pattern: String): String {
    val dateFormat: DateFormat = SimpleDateFormat(pattern, Locale.US)
    val date = Date()
    return dateFormat.format(date)
}


/**
 * Return string with reference to hours passed
 * */
fun convertDateTimeDifference(dateString: String, inputPattern: String, outputPattern: String): String {
    val sdf =
        SimpleDateFormat(inputPattern, Locale.getDefault())
    val calendar = Calendar.getInstance()
    calendar.timeZone = TimeZone.getTimeZone("UTC")
    try {
        calendar.time = sdf.parse(dateString)!!
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    val output =
        SimpleDateFormat(outputPattern, Locale.getDefault())


    val formatter = SimpleDateFormat(outputPattern, Locale.getDefault())

    /**
     * check if current time in long and date passes in long difference is ->
     * if less than 24hrs use today in UI
     * if greater than 24hrs and less than 48hrs use yesterday
     * */

    val differenceTime = Date().time - formatter.parse(output.format(calendar.time))!!.time

    /**
     * Convert difference time in long to hours
     * */
    val timeDifference = convertLongToHrs(differenceTime)
    val splitString = output.format(calendar.time).split(",")
    return when (timeDifference) {
        in 0..24 -> {
            return "TODAY ${splitString[1]}"
        }
        in 25..48 -> {
            return "YESTERDAY ${splitString[1]}"
        }
        else -> {
            output.format(calendar.time)
        }
    }
}


/**
 * Convert date to the pattern desired
 * */
fun convertDate(dateString: String, inputPattern: String, outputPattern: String): String {
    val sdf =
        SimpleDateFormat(inputPattern, Locale.getDefault())
    val calendar = Calendar.getInstance()
    calendar.timeZone = TimeZone.getTimeZone("UTC")
    try {
        calendar.time = sdf.parse(dateString)!!
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    val output =
        SimpleDateFormat(outputPattern, Locale.getDefault())

    return output.format(calendar.time)
}


fun convertLongToHrs(timeLong: Long): Int {
    return SimpleDateFormat("mm", Locale.getDefault()).format(Date(timeLong)).toInt()
}