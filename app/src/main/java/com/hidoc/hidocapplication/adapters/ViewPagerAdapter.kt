package com.hidoc.hidocapplication.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hidoc.hidocapplication.fragments.book.BookFragment
import com.hidoc.hidocapplication.fragments.news.NewsFragment

class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int): FragmentStateAdapter(fm, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                NewsFragment()
            }
            1 -> {
                BookFragment()
            }
            else -> NewsFragment()
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }

}