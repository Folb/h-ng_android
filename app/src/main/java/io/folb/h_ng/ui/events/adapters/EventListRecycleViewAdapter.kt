package io.folb.h_ng.ui.events.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import io.folb.h_ng.R
import io.folb.h_ng.models.Event
import io.folb.h_ng.ui.events.components.EventDescriptionFragment
import io.folb.h_ng.ui.events.components.EventGuestListFragment
import io.folb.h_ng.utils.enum.EventListType
import io.folb.h_ng.utils.toFormattedDate
import io.folb.h_ng.utils.toFormattedTime
import net.cachapa.expandablelayout.ExpandableLayout


class EventListRecycleViewAdapter(private val events: List<Event>, private val listType: EventListType) :
    RecyclerView.Adapter<EventListRecycleViewAdapter.ViewHolder>() {

    lateinit var recyclerView: RecyclerView
    private lateinit var visibleEvents: MutableList<Event>
    private lateinit var fragmentManager: FragmentManager
    private var viewPagerAdapter: EventListViewPagerAdapter? = null

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

            with(viewPager) {
                adapter = EventListViewPagerAdapter(fragmentManager, 0)
                    .apply {
                        addFragment(EventDescriptionFragment.newInstance(), "Description")
                        addFragment(EventGuestListFragment.newInstance(), "Guest List")
                    }
                tabLayout.setupWithViewPager(this)
            }
        }
    }

    override fun getItemCount(): Int = events.size

    fun setFragmentManager(fragmentManager: FragmentManager) {
        this.fragmentManager = fragmentManager
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), ExpandableLayout.OnExpansionUpdateListener {
        val startDate: TextView = view.findViewById(R.id.startDate)
        val startTime: TextView = view.findViewById(R.id.startTime)
        val endTime: TextView = view.findViewById(R.id.endTime)
        val title: TextView = view.findViewById(R.id.title)
        val location: TextView = view.findViewById(R.id.location)
        val createdBy: TextView = view.findViewById(R.id.createdBy)
        val expandableLayout: ExpandableLayout = view.findViewById(R.id.eventItemExpandableLayout)
        val viewPager: ViewPager = view.findViewById(R.id.eventItemViewPager)
        val tabLayout: TabLayout = view.findViewById(R.id.eventItemTabLayout)

        init {
            expandableLayout.setInterpolator(OvershootInterpolator())
            expandableLayout.setOnExpansionUpdateListener(this)
            view.setOnClickListener {
                expandableLayout.toggle()
            }
        }

        override fun onExpansionUpdate(expansionFraction: Float, state: Int) {
            if (state == ExpandableLayout.State.EXPANDING) {
                recyclerView.smoothScrollToPosition(adapterPosition)
            }
        }
    }
}