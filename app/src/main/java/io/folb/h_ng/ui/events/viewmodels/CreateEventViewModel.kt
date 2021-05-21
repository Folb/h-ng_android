package io.folb.h_ng.ui.events.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.folb.h_ng.io.repos.event.EventRepository
import io.folb.h_ng.models.Event
import io.folb.h_ng.utils.UserUtil
import io.folb.h_ng.utils.enum.defaultLocation
import io.folb.h_ng.utils.enum.defaultTitle
import java.time.LocalDateTime
import javax.inject.Inject

class CreateEventViewModel @Inject constructor(private val eventRepository: EventRepository) : ViewModel() {

     var title: MutableLiveData<String> = MutableLiveData()

     var location: MutableLiveData<String> = MutableLiveData()

     var startTime: MutableLiveData<LocalDateTime> = MutableLiveData()

     var endTime: MutableLiveData<LocalDateTime> = MutableLiveData()


     fun saveEvent() {
          //TODO: Error check form before submit
          val tit = title.value ?: defaultTitle
          val loc = location.value ?: defaultLocation
          val user = UserUtil.username
          val st = startTime.value ?: LocalDateTime.now()
          val et = endTime.value ?: st.plusHours(12)

          val event = Event(tit, loc, user, st, et)

          //TODO: Save event in backend
     }
}
