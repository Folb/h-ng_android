package io.folb.h_ng.models

import java.time.LocalDateTime

class Event(
    val title: String,
    val location: String,
    val createdBy: String,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime
)
