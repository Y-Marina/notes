package com.marina.notes.presentation.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.marina.notes.R
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

    @Composable
    fun formateDateToString(timestamp: Long): String {
        val now: Long = System.currentTimeMillis()
        val diff: Long = now - timestamp

        return when {
            diff < millisInHour -> stringResource(R.string.just_now)
            diff < millisInDay -> {
                val hours = TimeUnit.MILLISECONDS.toHours(diff)
                stringResource(R.string.h_ago, hours)
            }

            else -> {
                formatter.format(timestamp)
            }
        }
    }
}
