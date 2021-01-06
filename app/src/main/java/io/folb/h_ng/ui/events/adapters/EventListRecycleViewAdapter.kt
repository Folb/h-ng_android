package io.folb.h_ng.ui.events.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.folb.h_ng.R
import io.folb.h_ng.models.Event
import io.folb.h_ng.utils.enum.EventListType

import io.folb.h_ng.utils.toFormattedDate
import io.folb.h_ng.utils.toFormattedTime

class EventListRecycleViewAdapter(private val events: List<Event>, private val listType: EventListType) : RecyclerView.Adapter<EventListRecycleViewAdapter.ViewHolder>() {

    private lateinit var visibleEvents: MutableList<Event>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)

        filterList()

        return ViewHolder(view)
    }

    private fun filterList() {
        when (listType) {
            EventListType.Overview -> visibleEvents = events as MutableList<Event>
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = visibleEvents[position]
        with(holder) {
            startDate.text = event.startDateTime.toFormattedDate()
            startTime.text = event.startDateTime.toFormattedTime()
            endTime.text = event.endDateTime.toFormattedTime()
            title.text = event.title
            location.text = event.location
            createdBy.text = event.createdBy
        }
    }

    override fun getItemCount(): Int = events.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val startDate: TextView = view.findViewById(R.id.startDate)
        val startTime: TextView = view.findViewById(R.id.startTime)
        val endTime: TextView = view.findViewById(R.id.endTime)
        val title: TextView = view.findViewById(R.id.title)
        val location: TextView = view.findViewById(R.id.location)
        val createdBy: TextView = view.findViewById(R.id.createdBy)
    }
}