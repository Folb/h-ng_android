package io.folb.h_ng.ui.events.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.folb.h_ng.models.Event
import io.folb.h_ng.utils.UserUtil
import io.folb.h_ng.utils.enum.defaultLocation
import io.folb.h_ng.utils.enum.defaultTitle
import java.time.LocalDateTime

class CreateEventViewModel : ViewModel() {

     private var _title: MutableLiveData<String> = MutableLiveData()
     val title: LiveData<String> get() = _title

     private var _location: MutableLiveData<String> = MutableLiveData()
     val location: LiveData<String> get() = _location

     private var _startTime: MutableLiveData<LocalDateTime> = MutableLiveData()
     val startTime: LiveData<LocalDateTime> get() = _startTime

     private var _endTime: MutableLiveData<LocalDateTime> = MutableLiveData()
     val endTime: LiveData<LocalDateTime> get() = _endTime

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
