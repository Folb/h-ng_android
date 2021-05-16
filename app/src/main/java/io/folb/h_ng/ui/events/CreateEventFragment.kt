package io.folb.h_ng.ui.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import io.folb.h_ng.R
import io.folb.h_ng.databinding.CreateEventFragmentBinding
import io.folb.h_ng.ui.events.viewmodels.CreateEventViewModel

class CreateEventFragment : Fragment() {

    private lateinit var binding: CreateEventFragmentBinding
    private val vm by activityViewModels<CreateEventViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<CreateEventFragmentBinding>(inflater, R.layout.create_event_fragment, container, false)
            .apply {
                viewModel = vm

                btnCreateEvent.setOnClickListener {
                    vm.saveEvent()
                    //TODO: Navigate back to EventsListFragment
                }
            }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CreateEventFragment()
    }
}