package io.folb.h_ng.ui.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import io.folb.h_ng.R
import io.folb.h_ng.ui.events.adapters.EventListRecycleViewAdapter
import io.folb.h_ng.ui.events.viewmodels.EventsViewModel
import io.folb.h_ng.utils.enum.EventListType

class EventListFragment : Fragment() {

    private lateinit var listType: EventListType
    private lateinit var viewModel: EventsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            listType = when (it.getString(EVENT_LIST_TYPE_KEY)) {
                else -> EventListType.Overview
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_event_list_list, container, false)

        viewModel = ViewModelProvider(this).get(EventsViewModel::class.java)

        viewModel.getEvents().observe(viewLifecycleOwner, Observer {
            if (view is RecyclerView) {
                with(view) {
                    layoutManager = GridLayoutManager(context,  1)
                    adapter = EventListRecycleViewAdapter(it, listType).apply {
                        recyclerView = view
                    }

                    (adapter as EventListRecycleViewAdapter).setFragmentManager(childFragmentManager)
                }
            }
        })

        return view
    }

    companion object {
        const val EVENT_LIST_TYPE_KEY = "listType"

        @JvmStatic
        fun newInstance(listType: EventListType) =
            EventListFragment().apply {
                arguments = Bundle().apply {
                    putString(EVENT_LIST_TYPE_KEY, listType.type)
                }
            }
    }
}