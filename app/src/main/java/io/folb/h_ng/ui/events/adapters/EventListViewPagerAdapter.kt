package io.folb.h_ng.ui.events.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class EventListViewPagerAdapter(fragmentManager: FragmentManager, behavior: Int) : FragmentPagerAdapter(fragmentManager, behavior) {

    private val fragmentTitleList = mutableListOf<String>()
    private val fragmentList = mutableListOf<Fragment>()

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

    override fun getItem(position: Int): Fragment {
         return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }
}