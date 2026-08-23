package com.marina.notes.presentation.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit

object DateFormater {
    private val millisInHour = TimeUnit.HOURS.toMillis(1)
    private val millisInDay = TimeUnit.DAYS.toMillis(1)
    private val formatter = SimpleDateFormat.getDateInstance(DateFormat.SHORT)

    fun formatCurrentDate(): String {
        return formatter.format(System.currentTimeMillis())
    }

    fun formateDateToString(timestamp: Long): String {
        val now: Long = System.currentTimeMillis()
        val diff: Long = now - timestamp

        return when {
            diff < millisInHour -> "Just now"
            diff < millisInDay -> {
                val hours = TimeUnit.MILLISECONDS.toHours(diff)
                "$hours h ago"
            }

            else -> {
                formatter.format(timestamp)
            }
        }
    }
}
