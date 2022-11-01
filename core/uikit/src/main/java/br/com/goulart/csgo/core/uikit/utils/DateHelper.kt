package br.com.goulart.csgo.core.uikit.utils

import android.text.format.DateUtils
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.TextStyle
import java.util.*

fun String.toDate(
    dateFormat: String = "yyyy-MM-dd'T'HH:mm:ss'Z'",
    timeZone: TimeZone = TimeZone.getTimeZone("UTC"),
): Date? {
    val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
    parser.timeZone = timeZone
    return parser.parse(this)
}

fun Date.isToday(): Boolean {
    return DateUtils.isToday(this.time)
}

fun Date.isDayOfThisWeek(): Boolean {
    val today = LocalDate.now()

    var sunday = today
    while (sunday.dayOfWeek != DayOfWeek.SUNDAY) {
        sunday = sunday.minusDays(1)
    }
    sunday = sunday.minusDays(1)

    var saturday = today
    while (saturday.dayOfWeek != DayOfWeek.SATURDAY) {
        saturday = saturday.plusDays(1)
    }
    saturday = saturday.plusDays(1)

    val currentDate = this.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()

    return (currentDate.isAfter(sunday) && currentDate.isBefore(saturday)) || this.isToday()
}

fun Date.toEventTime(): String {
    val day = LocalDate.now().dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
    val time = SimpleDateFormat("HH:mm", Locale.getDefault())
        .format(this).toString()
    return "${day.replaceFirstChar { it.uppercase() }.replace(".", "")}, $time"
}

fun Date.toShortDate(): String {
    return SimpleDateFormat("dd.MM HH:mm", Locale.getDefault())
        .format(this).toString()
}