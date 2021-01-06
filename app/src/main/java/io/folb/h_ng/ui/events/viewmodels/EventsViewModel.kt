package io.folb.h_ng.ui.events.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.folb.h_ng.utils.TestUtils.rndDateTime
import io.folb.h_ng.utils.TestUtils.rndLocation
import io.folb.h_ng.utils.TestUtils.rndTitle
import io.folb.h_ng.utils.TestUtils.rndUser
import io.folb.h_ng.models.Event

class EventsViewModel : ViewModel() {
    private val events: MutableLiveData<List<Event>> by lazy {
        MutableLiveData<List<Event>>().also {
            it.value = loadEvents()
        }
    }

    fun getEvents(): LiveData<List<Event>> {
        return events
    }

    private fun loadEvents(): List<Event> {
        val list = mutableListOf<Event>()
        for (i in 1..10) {
            val title = rndTitle()
            val location = rndLocation()
            val createdBy = rndUser()
            val startDateTime = rndDateTime()
            val endDateTime = rndDateTime(startDateTime)
            list.add(
                Event(
                    title,
                    location,
                    createdBy,
                    startDateTime,
                    endDateTime
                )
            )
        }

        return list
    }
}