package io.folb.h_ng.ui.events.components

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.folb.h_ng.R

class EventDescriptionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_event_description, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = EventDescriptionFragment()
    }
}