package com.example.sopt26seminar2_webtoon

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> NewFragment()
            1 -> MonFragment()
            2 -> TueFragment()
            3 -> WedFragment()
            4 -> ThurFragment()
            5 -> FriFragment()
            6 -> SatFragment()
            7 -> SunFragment()
            else -> FinFragment()
        }
    }

    override fun getCount() = 9

}