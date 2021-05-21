package io.folb.h_ng.ui.events

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.folb.h_ng.R
import io.folb.h_ng.ui.events.viewmodels.EventsViewModel
import io.folb.h_ng.utils.enum.EventListType

class EventsOverviewFragment : Fragment() {

    companion object {
        fun newInstance() = EventsOverviewFragment()
    }

    private lateinit var viewModel: EventsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.events_overview_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val eventListFragment = EventListFragment.newInstance(EventListType.Overview)
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.eventListContainer, eventListFragment).commit()
    }
}