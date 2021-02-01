package io.folb.h_ng.ui.events.components

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import io.folb.h_ng.R
import io.folb.h_ng.databinding.FragmentExpandedEventItemBinding
import io.folb.h_ng.ui.events.adapters.EventListViewPagerAdapter

class ExpandedEventItemFragment : Fragment() {

    private lateinit var binding: FragmentExpandedEventItemBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_expanded_event_item, container, false)

        childFragmentManager.beginTransaction()
            .replace(R.id.timeFragmentContainer, EventTimeLineFragment.newInstance())
            .commit()

        with(binding) {
            eventItemViewPager.apply {
                adapter = EventListViewPagerAdapter(childFragmentManager, 0)
                    .apply {
                        addFragment(EventDescriptionFragment.newInstance(), "Description")
                        addFragment(EventGuestListFragment.newInstance(), "Guest list")
                    }
            }

            eventItemTabLayout.setupWithViewPager(eventItemViewPager)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ExpandedEventItemFragment()
    }
}