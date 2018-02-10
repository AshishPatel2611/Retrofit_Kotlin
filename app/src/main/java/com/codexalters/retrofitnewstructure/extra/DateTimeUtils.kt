package com.codexalters.retrofitnewstructure.extra

import android.os.Build
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by codexalters on 6/2/18.
 */
object DateTimeUtils {

    fun getDateDiffInDays(dateOne: Date, dateTwo: Date): String {

        val timeOne = dateOne.time
        val timeTwo = dateTwo.time
        val oneDay = (1000 * 60 * 60 * 24).toLong()
        var delta = (timeTwo - timeOne) / oneDay

        if (delta > 0) {
            return (delta + 1).toString() + " Days"
        } else {
            delta *= -1
            return "-$delta Days"
        }
    }

    fun getDateDifference(sessionStart: Date?, sessionEnd: Date?): String {
        if (sessionStart == null || sessionEnd == null)
            return ""

        val startDateTime = Calendar.getInstance()
        startDateTime.time = sessionStart

        val endDateTime = Calendar.getInstance()
        endDateTime.time = sessionEnd

        val milliseconds1 = startDateTime.timeInMillis
        val milliseconds2 = endDateTime.timeInMillis
        val diff = milliseconds2 - milliseconds1

        val hours = diff / (60 * 60 * 1000)
        var minutes = diff / (60 * 1000)
        minutes -= 60 * hours
        val seconds = diff / 1000

        return if (hours > 0) {
            hours.toString() + " hours " + minutes + " minutes"
        } else {
            if (minutes > 0)
                minutes.toString() + " minutes"
            else {
                seconds.toString() + " seconds"
            }
        }
    }

    fun getStringFromDate(dateFormat: String, date: Date): String? {
        var newString: String? = null
        try {
            var newFormat: SimpleDateFormat? = null
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                newFormat = SimpleDateFormat(dateFormat)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                newString = newFormat!!.format(date)
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return newString
    }


    fun getDateFromString(dateString: String): Date {

        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        try {
            return format.parse(dateString)
        } catch (e: ParseException) {
            e.printStackTrace()
            return Date()
        }
    }


}