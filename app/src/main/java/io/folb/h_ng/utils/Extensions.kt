package io.folb.h_ng.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.toFormattedDate(): String {
    val formatter = DateTimeFormatter.ofPattern("dd.LLL")
    return format(formatter)
}

fun LocalDateTime.toFormattedTime(): String {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    return format(formatter)
}
