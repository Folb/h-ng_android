package io.folb.h_ng.utils

import java.time.LocalDateTime


object TestUtils {

    private val titles = listOf("TestTitle", "A way too long title that should have been an email and the creator is possibly a potato", "A midsize and descriptive title")
    private val locations = listOf("Test Location road 23", "Test Location street 58", "The best location 1")
    private val users = listOf("User 1", "User 2", "User 3", "User 69")

    fun rndTitle(): String {
        return titles[rnd(titles.size)]
    }

    fun rndLocation(): String {
        return locations[rnd(locations.size)]
    }

    fun rndUser(): String {
        return users[rnd(users.size)]
    }

    fun rndDateTime(after: LocalDateTime = LocalDateTime.now()): LocalDateTime {
        return LocalDateTime.of(after.year, after.month, after.dayOfMonth, after.hour + rnd(4), after.minute)
    }

    private fun rnd(n: Int): Int {
        return (Math.random() * n - 1).toInt()
    }

}