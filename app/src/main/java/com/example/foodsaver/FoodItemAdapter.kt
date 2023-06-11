package com.example.foodsaver

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FoodItemAdapter(fm: FragmentManager, private val tabCounts: Int) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FoodsFragment()
            1 -> FoodsFragment()
            2 -> FoodsFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

    override fun getCount(): Int {
        return tabCounts
    }
}
